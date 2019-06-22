package ru.example.deployable.converter;

import org.springframework.stereotype.Component;
import ru.example.deployable.domain.RealmEntity;
import ru.example.deployable.domain.RealmRequest;
import ru.example.deployable.domain.RealmResponse;
import java.util.UUID;

@Component
public class RealmConverter {

	public RealmEntity convert(RealmRequest realmRequest) {
		return new RealmEntity()
			.setName(realmRequest.getName())
			.setDescription(realmRequest.getDescription())
			.setKey(UUID.randomUUID().toString());
	}

	public RealmResponse convert(RealmEntity realmEntity) {
		RealmResponse response = new RealmResponse();
		response.setDescription(realmEntity.getDescription());
		response.setName(realmEntity.getName());
		response.setId(realmEntity.getId());
		response.setKey(realmEntity.getKey());
		return response;
	}
}
