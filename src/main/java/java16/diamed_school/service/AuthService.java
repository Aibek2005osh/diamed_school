package java16.diamed_school.service;

import java16.diamed_school.dto.request.SignInRequest;
import java16.diamed_school.dto.request.SignUpRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> signUp(SignUpRequest signUpRequest);

    ResponseEntity<?> signIn(SignInRequest signInRequest);
}
