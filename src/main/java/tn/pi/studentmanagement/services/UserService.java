package tn.pi.studentmanagement.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import tn.pi.studentmanagement.tools.dtos.request.UserRequest;
import tn.pi.studentmanagement.tools.dtos.response.UserResponse;

import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();

    List<UserResponse> findAllUsers();

    UserResponse findByEmail(String email);

    boolean deleteUser(String email);

    UserResponse createUser(UserRequest userRequest);

    boolean lockUserAccount(String email);

    boolean unLockUserAccount(String email);

}
