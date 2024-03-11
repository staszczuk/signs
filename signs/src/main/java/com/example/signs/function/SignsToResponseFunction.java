package com.example.signs.function;

import com.example.signs.dto.GetSignsResponse;
import com.example.signs.entity.Sign;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class SignsToResponseFunction implements Function<List<Sign>, GetSignsResponse> {

    @Override
    public GetSignsResponse apply(List<Sign> signs) {
        return GetSignsResponse.builder()
                .signs(signs.stream()
                        .map(sign -> GetSignsResponse.Sign.builder()
                                .id(sign.getId())
                                .name(sign.getName())
                                .build())
                        .toList())
                .build();
    }

}
