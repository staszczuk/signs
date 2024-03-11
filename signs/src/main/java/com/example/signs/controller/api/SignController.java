package com.example.signs.controller.api;

import com.example.signs.dto.GetSignResponse;
import com.example.signs.dto.GetSignsResponse;
import com.example.signs.dto.PatchSignRequest;
import com.example.signs.dto.PutSignRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface SignController {

    @DeleteMapping("/api/signs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteSign(
            @PathVariable("id")
            UUID id
    );

    @GetMapping("/api/signs/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSignResponse getSign(
            @PathVariable("id")
            UUID id
    );

    @GetMapping("/api/signs")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSignsResponse getSigns();

    @GetMapping("/api/signtypes/{id}/signs")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSignsResponse getSignsBySignType(
            @PathVariable("id")
            UUID id
    );

    @PatchMapping("/api/signs/{id}")
    @ResponseStatus(HttpStatus.OK)
    void patchSign(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchSignRequest request
    );

    @PutMapping("/api/signs/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putSign(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutSignRequest request
    );

}
