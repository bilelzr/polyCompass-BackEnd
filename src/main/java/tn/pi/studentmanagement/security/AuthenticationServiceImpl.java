package tn.pi.studentmanagement.security;


import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.pi.studentmanagement.entities.Role;
import tn.pi.studentmanagement.entities.User;
import tn.pi.studentmanagement.repositories.UserRepository;
import tn.pi.studentmanagement.tools.dtos.DtoMapper;
import tn.pi.studentmanagement.tools.dtos.request.SignUpRequest;
import tn.pi.studentmanagement.tools.dtos.request.SigninRequest;
import tn.pi.studentmanagement.tools.dtos.request.UserRequest;
import tn.pi.studentmanagement.tools.dtos.response.JwtAuthenticationResponse;
import tn.pi.studentmanagement.tools.dtos.response.UserResponse;
import tn.pi.studentmanagement.tools.exceptions.UserAlreadyExistsException;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        // Check if a user with the given email already exists
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            // User with the given email already exists, handle accordingly (throw an exception, return an error response, etc.)
            // For simplicity, let's assume you want to throw an exception
            throw new UserAlreadyExistsException("An account with email " + request.getEmail() + " already exists ");
        }
        // User with the given email doesn't exist, proceed to create a new user
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.SUPER_ADMIN)
                .build();

        userRepository.save(user);

        // Generate JWT token for the newly created user
        var jwt = jwtService.generateToken(user);

        // Return the JWT token in the response
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }


    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        // Authenticate the user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        // Set authentication in SecurityContext
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Get the email (username) of the authenticated user
        String email = authentication.getName();

        // Find the user by email in the repository
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Authenticated user not found"));

        // Generate JWT token for the authenticated user
        String jwt = jwtService.generateToken(user);

        // Return the JWT token along with user information in the response
        return JwtAuthenticationResponse.builder()
                .token(jwt)
                .build();
    }

    @Override
    public UserResponse createNewUser(UserRequest userRequest) {
        User user = new User();
        user.setAddress(userRequest.getAddress());
        user.setEmail(userRequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(userRequest.getPassword()));
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setRole(userRequest.getRole());
        user.setAccountNonLocked(true);
        userRepository.save(user);
        return DtoMapper.mapUserToDto(user);
    }
}
