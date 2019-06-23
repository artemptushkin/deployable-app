package ru.example.deployable.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.example.deployable.domain.RealmRequest;
import ru.example.deployable.domain.RealmResponse;
import ru.example.deployable.service.RealmService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Collections;

@Validated
@RequiredArgsConstructor
@RestController("/service/user/realm")
public class RealmController {

	private final RealmService realmService;

	@PostMapping(
		value = "/realm",
		consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE, "application/xml; charset=utf-8" },
		produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, "application/xml; charset=utf-8" }
	)
	public ResponseEntity<RealmResponse> createRealm(@Valid @RequestBody RealmRequest realmRequest,
	                                                 HttpServletRequest request) {
		RealmResponse response = realmService.createRealm(realmRequest);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.put(HttpHeaders.DATE, Collections.singletonList(LocalDateTime.now().toString()));
		return new ResponseEntity<>(
			response, httpHeaders, HttpStatus.CREATED
		);
	}

	@GetMapping(
		value = "realm/{id}"
	)
	public ResponseEntity<RealmResponse> getRealm(@PathVariable Long id) {
		RealmResponse response = realmService.getRealm(id);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.put(HttpHeaders.DATE, Collections.singletonList(LocalDateTime.now().toString()));
		return new ResponseEntity<>(
			response, httpHeaders, HttpStatus.CREATED
		);
	}
}
