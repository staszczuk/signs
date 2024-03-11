package com.example.signtypes.function;

import com.example.signtypes.dto.GetSignTypeResponse;
import com.example.signtypes.entity.SignType;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SignTypeToResponse implements Function<SignType, GetSignTypeResponse> {

    @Override
    public GetSignTypeResponse apply(SignType signType) {
        return GetSignTypeResponse.builder()
                .id(signType.getId())
                .name(signType.getName())
                .codePrefix(signType.getCodePrefix())
                .build();
    }

}
