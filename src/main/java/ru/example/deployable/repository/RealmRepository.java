package ru.example.deployable.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.example.deployable.domain.RealmEntity;

@Repository
@Transactional
public interface RealmRepository extends CrudRepository<RealmEntity, Long> {
	boolean existsByName(String name);
}
