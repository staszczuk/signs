package com.example.signs.controller.impl;

import com.example.signs.controller.api.SignTypeController;
import com.example.signs.entity.SignType;
import com.example.signs.service.api.SignTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class SignTypeDefaultController implements SignTypeController {

    private final SignTypeService signTypeService;

    public SignTypeDefaultController(SignTypeService signTypeService) {
        this.signTypeService = signTypeService;
    }

    @Override
    public void createSignType(UUID id) {
        signTypeService.create(SignType.builder().id(id).build());
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

}
