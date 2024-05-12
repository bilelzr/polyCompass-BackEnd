package tn.pi.studentmanagement.tools.dtos.request;

import lombok.Builder;
import lombok.Data;
import tn.pi.studentmanagement.entities.Role;


@Data
@Builder
public class UserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private Role role;
}
