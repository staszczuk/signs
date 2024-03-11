package com.example.signtypes.function;

import com.example.signtypes.dto.PatchSignTypeRequest;
import com.example.signtypes.entity.SignType;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateRequestToSignTypeFunction implements BiFunction<SignType, PatchSignTypeRequest, SignType> {

    @Override
    public SignType apply(SignType signType, PatchSignTypeRequest patchSignTypeRequest) {
        return SignType.builder()
                .id(signType.getId())
                .name(patchSignTypeRequest.getName())
                .codePrefix(patchSignTypeRequest.getCodePrefix())
                .build();
    }

}
