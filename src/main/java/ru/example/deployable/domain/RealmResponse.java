package ru.example.deployable.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "realm")
@XmlAccessorType(XmlAccessType.PROPERTY)
@EqualsAndHashCode(callSuper = true)
public class RealmResponse extends RealmEntity {

	@Override
	@XmlAttribute
	public RealmEntity setId(Long id) {
		return super.setId(id);
	}

	@Override
	@XmlAttribute
	public RealmEntity setName(String name) {
		return super.setName(name);
	}

	@Override
	@XmlElement
	public RealmEntity setDescription(String description) {
		return super.setDescription(description);
	}

	@Override
	@XmlElement
	public RealmEntity setKey(String key) {
		return super.setKey(key);
	}
}
