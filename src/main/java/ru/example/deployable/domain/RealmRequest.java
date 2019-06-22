package ru.example.deployable.domain;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "realm")
@XmlAccessorType(XmlAccessType.FIELD)
public class RealmRequest {
	@NotEmpty
	@UniqueByName(message = "DuplicateRealmName")
	@XmlAttribute
	private String name;
	@XmlElement
	private String description;
}
