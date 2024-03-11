package com.example.signtypes.controller.impl;

import com.example.signtypes.controller.api.SignTypeController;
import com.example.signtypes.dto.GetSignTypeResponse;
import com.example.signtypes.dto.GetSignTypesResponse;
import com.example.signtypes.dto.PatchSignTypeRequest;
import com.example.signtypes.dto.PutSignTypeRequest;
import com.example.signtypes.function.PutRequestToSignTypeFunction;
import com.example.signtypes.function.SignTypeToResponse;
import com.example.signtypes.function.SignTypesToResponse;
import com.example.signtypes.function.UpdateRequestToSignTypeFunction;
import com.example.signtypes.service.api.SignTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class SignTypeDefaultController implements SignTypeController {

    private final PutRequestToSignTypeFunction putRequestToSignTypeFunction;
    private final SignTypeService signTypeService;
    private final SignTypesToResponse signTypesToResponse;
    private final SignTypeToResponse signTypeToResponse;
    private final UpdateRequestToSignTypeFunction updateRequestToSignTypeFunction;

    public SignTypeDefaultController(
            PutRequestToSignTypeFunction putRequestToSignTypeFunction,
            SignTypeService signTypeService,
            SignTypesToResponse signTypesToResponse,
            SignTypeToResponse signTypeToResponse,
            UpdateRequestToSignTypeFunction updateRequestToSignTypeFunction
    ) {
        this.putRequestToSignTypeFunction = putRequestToSignTypeFunction;
        this.signTypeService = signTypeService;
        this.signTypesToResponse = signTypesToResponse;
        this.signTypeToResponse = signTypeToResponse;
        this.updateRequestToSignTypeFunction = updateRequestToSignTypeFunction;
    }

    @Override
    public void deleteSignType(UUID id) {
        signTypeService.find(id)
                .ifPresentOrElse(
                        signType -> signTypeService.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @Override
    public GetSignTypeResponse getSignType(UUID id) {
        return signTypeService.find(id)
                .map(signTypeToResponse)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
    }

    @Override
    public GetSignTypesResponse getSignTypes() {
        return signTypesToResponse.apply(signTypeService.findAll());
    }

    @Override
    public void patchSignType(UUID id, PatchSignTypeRequest request) {
        signTypeService.find(id)
                .ifPresentOrElse(
                        signType -> signTypeService.update(updateRequestToSignTypeFunction.apply(signType, request)),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @Override
    public void putSignType(UUID id, PutSignTypeRequest request) {
        signTypeService.create(putRequestToSignTypeFunction.apply(id, request));
    }

}
