package com.example.signs.dto;

import com.example.signs.entity.Color;
import com.example.signs.entity.Shape;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class GetSignResponse {

    private UUID id;
    private String name;
    private String codePostfix;
    private Color color;
    private Shape shape;
    private SignType signType;

    @AllArgsConstructor
    @Builder
    @Data
    @NoArgsConstructor
    public static class SignType {
        private UUID id;
        private String name;
    }

}
