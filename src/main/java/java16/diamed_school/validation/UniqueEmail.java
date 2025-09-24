package java16.diamed_school.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java16.diamed_school.validation.impl.UniqueEmailValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueEmailValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {
    String message() default "Этот электронный адрес уже зарегистрирован";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
