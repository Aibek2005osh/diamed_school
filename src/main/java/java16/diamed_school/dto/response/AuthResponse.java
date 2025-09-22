package java16.diamed_school.dto.response;

import java16.diamed_school.emums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder @Getter
@Setter
public class AuthResponse {
    private Long id;
    private String email;
    private Role role;
    private String token;

    @Override
    public String toString() {
        return "      AuthResponse" +
                "id     : " + id + '\n' +
                "email  : " + email + '\n' +
                "role   : " + role + '\n' +
                "token  : " + token ;
    }
}
