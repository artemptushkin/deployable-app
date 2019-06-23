package ru.example.deployable.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.example.deployable.domain.RealmRequest;
import ru.example.deployable.domain.RealmResponse;
import ru.example.deployable.service.RealmService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Collections;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/service/user")
public class RealmController {

    private final RealmService realmService;

    @RequestMapping(
            value = "/realm",
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, "application/xml; charset=utf-8"},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, "application/xml; charset=utf-8"},
            method = RequestMethod.POST
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

    @RequestMapping(
            value = "/realm/{id}",
            method = RequestMethod.GET
    )
    public ResponseEntity<RealmResponse> getRealm(@Valid @PathVariable Long id) {
        RealmResponse response = realmService.getRealm(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put(HttpHeaders.DATE, Collections.singletonList(LocalDateTime.now().toString()));
        return new ResponseEntity<>(
                response, httpHeaders, HttpStatus.OK
        );
    }
}
