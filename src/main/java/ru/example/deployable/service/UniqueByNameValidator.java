package ru.example.deployable.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.example.deployable.domain.UniqueByName;
import ru.example.deployable.repository.RealmRepository;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class UniqueByNameValidator implements ConstraintValidator<UniqueByName, String> {

	private final RealmRepository realmRepository;

	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
		return !realmRepository.existsByName(name);
	}
}
