package com.example.signtypes.function;

import com.example.signtypes.dto.PutSignTypeRequest;
import com.example.signtypes.entity.SignType;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class PutRequestToSignTypeFunction implements BiFunction<UUID, PutSignTypeRequest, SignType> {

    @Override
    public SignType apply(UUID uuid, PutSignTypeRequest putSignTypeRequest) {
        return SignType.builder()
                .id(uuid)
                .name(putSignTypeRequest.getName())
                .codePrefix(putSignTypeRequest.getCodePrefix())
                .build();
    }

}
