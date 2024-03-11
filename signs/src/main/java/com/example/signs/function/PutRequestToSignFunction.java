package com.example.signs.function;

import com.example.signs.dto.PutSignRequest;
import com.example.signs.entity.Sign;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class PutRequestToSignFunction implements BiFunction<UUID, PutSignRequest, Sign> {

    @Override
    public Sign apply(UUID uuid, PutSignRequest putSignRequest) {
        return Sign.builder()
                .id(uuid)
                .name(putSignRequest.getName())
                .codePostfix(putSignRequest.getCodePostfix())
                .color(putSignRequest.getColor())
                .shape(putSignRequest.getShape())
                .build();
    }

}
