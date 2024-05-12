package tn.pi.studentmanagement.tools.dtos.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmergencyContactResponse {
    private String name;
    private String studentRelated;
    private long phoneNumber;
}
