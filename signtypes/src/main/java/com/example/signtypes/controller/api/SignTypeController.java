package com.example.signtypes.controller.api;

import com.example.signtypes.dto.GetSignTypeResponse;
import com.example.signtypes.dto.GetSignTypesResponse;
import com.example.signtypes.dto.PatchSignTypeRequest;
import com.example.signtypes.dto.PutSignTypeRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface SignTypeController {

    @DeleteMapping("/api/signtypes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteSignType(
            @PathVariable("id")
            UUID id
    );

    @GetMapping("/api/signtypes/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSignTypeResponse getSignType(
            @PathVariable("id")
            UUID id
    );

    @GetMapping("/api/signtypes")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSignTypesResponse getSignTypes();

    @PatchMapping("/api/signtypes/{id}")
    @ResponseStatus(HttpStatus.OK)
    void patchSignType(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchSignTypeRequest request
    );

    @PutMapping("/api/signtypes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putSignType(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutSignTypeRequest request
    );

}
