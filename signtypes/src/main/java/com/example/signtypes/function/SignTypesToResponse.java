package com.example.signtypes.function;

import com.example.signtypes.dto.GetSignTypesResponse;
import com.example.signtypes.entity.SignType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class SignTypesToResponse implements Function<List<SignType>, GetSignTypesResponse> {

    @Override
    public GetSignTypesResponse apply(List<SignType> signTypes) {
        return GetSignTypesResponse.builder()
                .signTypes(signTypes.stream()
                        .map(signType -> GetSignTypesResponse.SignType.builder()
                                .id(signType.getId())
                                .name(signType.getName())
                                .build())
                        .toList())
                .build();
    }

}
