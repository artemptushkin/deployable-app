package ru.example.deployable.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Data
@JacksonXmlRootElement(localName = "realm")
@XmlAccessorType(XmlAccessType.PROPERTY)
@EqualsAndHashCode(callSuper = true)
public class RealmResponse extends RealmEntity {

	@Override
	@JacksonXmlProperty(isAttribute = true)
	public RealmEntity setId(Long id) {
		return super.setId(id);
	}

	@Override
	@JacksonXmlProperty(isAttribute = true)
	public RealmEntity setName(String name) {
		return super.setName(name);
	}

	@Override
	@JacksonXmlProperty
	public RealmEntity setDescription(String description) {
		return super.setDescription(description);
	}

	@Override
	@JacksonXmlProperty
	public RealmEntity setKey(String key) {
		return super.setKey(key);
	}
}
