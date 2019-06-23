package ru.example.deployable.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.example.deployable.service.CompositeNegotiationStrategy;

@EnableWebMvc
@Configuration
public class ContentNegotiationConfiguration implements WebMvcConfigurer {
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer
			.favorPathExtension(false)
			.defaultContentTypeStrategy(new CompositeNegotiationStrategy());
	}
}
