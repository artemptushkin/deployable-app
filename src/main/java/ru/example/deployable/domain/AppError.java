package ru.example.deployable.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Accessors(chain = true)
@XmlRootElement(name = "error")
@XmlAccessorType(XmlAccessType.FIELD)
public class AppError {
	@XmlElement
	private String code;
}
