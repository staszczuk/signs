package com.example.signs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class GetSignsResponse {

    private List<Sign> signs;

    @AllArgsConstructor
    @Builder
    @Data
    @NoArgsConstructor
    public static class Sign {
        private UUID id;
        private String name;
    }
}
