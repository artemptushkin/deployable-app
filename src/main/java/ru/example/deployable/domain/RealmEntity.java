package ru.example.deployable.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "realm")
@Accessors(chain = true)
public class RealmEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", unique = true)
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "key")
	private String key;
}
