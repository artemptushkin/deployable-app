package ru.example.deployable.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.deployable.converter.RealmConverter;
import ru.example.deployable.domain.RealmEntity;
import ru.example.deployable.domain.RealmNotFoundException;
import ru.example.deployable.domain.RealmRequest;
import ru.example.deployable.domain.RealmResponse;
import ru.example.deployable.repository.RealmRepository;

@Service
@RequiredArgsConstructor
public class RealmService {

	private final RealmConverter realmConverter;
	private final RealmRepository realmRepository;

	public RealmResponse createRealm(RealmRequest realmRequest) {
		RealmEntity realmEntity = realmRepository.save(
			realmConverter.convert(realmRequest)
		);
		return realmConverter.convert(realmEntity);
	}

	public RealmResponse getRealm(Long id) {
		return realmRepository.findById(id)
			.map(realmConverter::convert)
			.orElseThrow(RealmNotFoundException::new);

	}
}
