package ru.example.deployable.domain;

import ru.example.deployable.service.UniqueByNameValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy = UniqueByNameValidator.class)
@Retention(RUNTIME)
public @interface UniqueByName {
	String message();
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
}
