package tn.pi.studentmanagement.tools.dtos.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}

