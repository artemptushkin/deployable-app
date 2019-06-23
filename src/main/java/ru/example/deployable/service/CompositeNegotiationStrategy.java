package ru.example.deployable.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.InvalidMediaTypeException;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeNegotiationStrategy implements ContentNegotiationStrategy {
	@Override
	public List<MediaType> resolveMediaTypes(NativeWebRequest request) throws HttpMediaTypeNotAcceptableException {

		String[] acceptHeader = request.getHeaderValues(HttpHeaders.ACCEPT);
		String[] contentTypeHeader = request.getHeaderValues(HttpHeaders.CONTENT_TYPE);
		if (acceptHeader == null || contentTypeHeader == null) {
			return MEDIA_TYPE_ALL_LIST;
		}

		List<String> headerValues = new ArrayList<>(Arrays.asList(contentTypeHeader));
		headerValues.addAll(Arrays.asList(acceptHeader));
		try {
			List<MediaType> mediaTypes = MediaType.parseMediaTypes(headerValues);
			MediaType.sortBySpecificityAndQuality(mediaTypes);
			return !CollectionUtils.isEmpty(mediaTypes) ? mediaTypes : MEDIA_TYPE_ALL_LIST;
		}
		catch (InvalidMediaTypeException ex) {
			throw new HttpMediaTypeNotAcceptableException(
				"Could not parse 'Accept' or 'Content-Type' header " + headerValues + ": " + ex.getMessage());
		}
	}
}
