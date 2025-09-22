package java16.diamed_school.service.impl;

import java16.diamed_school.config.jwt.JwtService;
import java16.diamed_school.dto.request.SignInRequest;
import java16.diamed_school.dto.request.SignUpRequest;
import java16.diamed_school.dto.response.AuthResponse;
import java16.diamed_school.emums.Role;
import java16.diamed_school.entity.User;
import java16.diamed_school.repository.UserRepository;
import java16.diamed_school.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public ResponseEntity<AuthResponse> signUp(SignUpRequest request) {
        User user = new User();
        user.setPnoneNumber(request.getPhoneNumber());
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.STUDENT);
        userRepository.save(user);

        return ResponseEntity.ok(AuthResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .role(user.getRole())
                .token(jwtService.generateToken(user))
                .build());
    }

    @Override
    public ResponseEntity<?> signIn(SignInRequest request) {
        try {
            User user = userRepository.findByEmailException(request.getEmail());
            if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                return ResponseEntity.status(401).body("Неверный пароль!");
            }
            return ResponseEntity.ok(AuthResponse.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .role(user.getRole())
                    .token(jwtService.generateToken(user))
                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Ошибка при входе: " + e.getMessage());
        }
    }
}