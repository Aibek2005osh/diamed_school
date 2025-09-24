package java16.diamed_school.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SignUpRequest {

    @NotBlank(message = "Ф.И.О не должно быть пустым! ")
    @Size(min = 2, max = 60, message = "Ф.И.О должна содержать от 2 до 60 символов !")
    private String fullName;
    @NotBlank(message = "Номер телефона не должен быть пустым!")
    @Size(min = 10, max = 13, message = "Номер телефона должен содержать от 10 до 13 символов!")
    @Pattern(
            regexp = "^(\\+7[0-9]{10}|\\+996[0-9]{9}|\\+998[0-9]{9})$",
            message = "Номер телефона должен быть в правильном формате! Примеры: +79123456789, +996123456789, +998123456789"
    )
    private String phoneNumber;
    @Email
    @NotBlank(message = "Электронная почта не должна быть пустой!")
    private String email;
    @NotBlank(message = "Пароль не должен быть пустым!")
    @Size(min = 6, max = 18, message = "Пароль должен содержать от 6 до 18 символов!")
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]*$",
            message = "Пароль должен содержать как минимум одну букву, одну цифру и один специальный символ!"
    )
    private String password;


}
