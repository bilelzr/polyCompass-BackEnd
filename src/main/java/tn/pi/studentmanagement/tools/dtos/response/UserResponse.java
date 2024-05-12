package tn.pi.studentmanagement.tools.dtos.response;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class UserResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private String role;
    private boolean accountStatus;
}
