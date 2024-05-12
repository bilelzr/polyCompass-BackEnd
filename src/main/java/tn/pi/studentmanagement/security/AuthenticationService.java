package tn.pi.studentmanagement.security;

import tn.pi.studentmanagement.tools.dtos.request.SignUpRequest;
import tn.pi.studentmanagement.tools.dtos.request.SigninRequest;
import tn.pi.studentmanagement.tools.dtos.request.UserRequest;
import tn.pi.studentmanagement.tools.dtos.response.JwtAuthenticationResponse;
import tn.pi.studentmanagement.tools.dtos.response.UserResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);

    UserResponse createNewUser(UserRequest userRequest);
}
