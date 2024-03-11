package com.example.signs.function;

import com.example.signs.dto.PatchSignRequest;
import com.example.signs.entity.Sign;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateRequestToSignFunction implements BiFunction<Sign, PatchSignRequest, Sign> {

    @Override
    public Sign apply(Sign sign, PatchSignRequest patchSignRequest) {
        return Sign.builder()
                .id(sign.getId())
                .name(patchSignRequest.getName())
                .codePostfix(patchSignRequest.getCodePostfix())
                .color(patchSignRequest.getColor())
                .shape(patchSignRequest.getShape())
                .build();
    }

}
