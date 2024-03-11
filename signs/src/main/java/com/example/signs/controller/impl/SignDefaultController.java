package com.example.signs.controller.impl;

import com.example.signs.controller.api.SignController;
import com.example.signs.dto.GetSignResponse;
import com.example.signs.dto.GetSignsResponse;
import com.example.signs.dto.PatchSignRequest;
import com.example.signs.dto.PutSignRequest;
import com.example.signs.function.PutRequestToSignFunction;
import com.example.signs.function.SignToResponseFunction;
import com.example.signs.function.SignsToResponseFunction;
import com.example.signs.function.UpdateRequestToSignFunction;
import com.example.signs.service.api.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class SignDefaultController implements SignController {

    private final PutRequestToSignFunction putRequestToSignFunction;
    private final SignService signService;
    private final SignsToResponseFunction signsToResponseFunction;
    private final SignToResponseFunction signToResponseFunction;
    private final UpdateRequestToSignFunction updateRequestToSignFunction;

    @Autowired
    public SignDefaultController(
            PutRequestToSignFunction putRequestToSignFunction,
            SignService signService,
            SignsToResponseFunction signsToResponseFunction,
            SignToResponseFunction signToResponseFunction,
            UpdateRequestToSignFunction updateRequestToSignFunction
    ) {
        this.putRequestToSignFunction = putRequestToSignFunction;
        this.signService = signService;
        this.signsToResponseFunction = signsToResponseFunction;
        this.signToResponseFunction = signToResponseFunction;
        this.updateRequestToSignFunction = updateRequestToSignFunction;
    }

    @Override
    public void deleteSign(UUID id) {
        signService.find(id)
                .ifPresentOrElse(
                        sign -> signService.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @Override
    public GetSignResponse getSign(UUID id) {
        return signService.find(id)
                .map(signToResponseFunction)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
    }

    @Override
    public GetSignsResponse getSigns() {
        return signsToResponseFunction.apply(signService.findAll());
    }

    @Override
    public GetSignsResponse getSignsBySignType(UUID id) {
        return signsToResponseFunction.apply(signService.findAll());
    }

    @Override
    public void patchSign(UUID id, PatchSignRequest request) {
        signService.find(id)
                .ifPresentOrElse(
                        sign -> signService.update(updateRequestToSignFunction.apply(sign, request)),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @Override
    public void putSign(UUID id, PutSignRequest request) {
        signService.create(putRequestToSignFunction.apply(id, request));
    }

}
