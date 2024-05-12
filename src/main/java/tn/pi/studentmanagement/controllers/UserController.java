package tn.pi.studentmanagement.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pi.studentmanagement.security.AuthenticationService;
import tn.pi.studentmanagement.services.UserService;
import tn.pi.studentmanagement.tools.dtos.request.UserRequest;
import tn.pi.studentmanagement.tools.dtos.response.UserResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    private final AuthenticationService authenticationService;

    public UserController(UserService userService, AuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable("email") String email) {
        if (email.isEmpty()) {
            return ResponseEntity.badRequest().body("Email cannot be null or empty");
        }
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @PostMapping("/new")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(authenticationService.createNewUser(userRequest));
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("email") String email) {
        return ResponseEntity.ok(userService.deleteUser(email));
    }


    @PutMapping("/lockAccount/{email}")
    public ResponseEntity<Boolean> lockUserAccount(@PathVariable("email") String email) {
        return ResponseEntity.ok(userService.lockUserAccount(email));
    }

    @PutMapping("/unLockAccount/{email}")
    public ResponseEntity<Boolean> unLockUserAccount(@PathVariable("email") String email) {
        return ResponseEntity.ok(userService.unLockUserAccount(email));
    }


}
