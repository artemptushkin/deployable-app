package ru.example.deployable.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
@JacksonXmlRootElement(localName = "realm")
public class RealmRequest {
	@NotEmpty(message = "InvalidRealmName")
	@UniqueByName(message = "DuplicateRealmName")
	@JacksonXmlProperty(isAttribute = true)
	private String name;
	@JacksonXmlProperty
	private String description;
}
