package com.example.signs.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

public interface SignTypeController {

    @PutMapping("/api/signtypes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void createSignType(
            @PathVariable("id")
            UUID id
    );

    @DeleteMapping("/api/signtypes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteSignType(
            @PathVariable("id")
            UUID id
    );

}
