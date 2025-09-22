package java16.diamed_school.api;

import java16.diamed_school.dto.request.SignUpRequest;
import java16.diamed_school.dto.request.SignInRequest;
import java16.diamed_school.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthApi {
    private final AuthService authService;


    @PostMapping("sign-up")
    ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest) {
        return authService.signUp(signUpRequest);

    }
    @PostMapping("sign-in")
    ResponseEntity<?> signIn(@RequestBody SignInRequest signInRequest){
      return   authService.signIn(signInRequest);
    }
}
