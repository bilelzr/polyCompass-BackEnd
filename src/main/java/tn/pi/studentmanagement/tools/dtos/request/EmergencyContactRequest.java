package tn.pi.studentmanagement.tools.dtos.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmergencyContactRequest {
    private String name;
    private String studentRelated;
    private long phoneNumber;
}
