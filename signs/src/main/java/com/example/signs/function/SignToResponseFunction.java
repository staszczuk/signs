package com.example.signs.function;

import com.example.signs.dto.GetSignResponse;
import com.example.signs.entity.Sign;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SignToResponseFunction implements Function<Sign, GetSignResponse> {

    @Override
    public GetSignResponse apply(Sign sign) {
        return GetSignResponse.builder()
                .id(sign.getId())
                .name(sign.getName())
                .codePostfix(sign.getCodePostfix())
                .color(sign.getColor())
                .shape(sign.getShape())
                .signType(GetSignResponse.SignType.builder()
                        .id(sign.getSignType().getId())
                        .build())
                .build();
    }
}
