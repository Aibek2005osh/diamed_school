package java16.diamed_school.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class SignUpRequest {
private String fullName;
private String phoneNumber;
private String email;
private String password;



}
