package com.example.signtypes.dto;

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
public class GetSignTypesResponse {

    private List<SignType> signTypes;

    @AllArgsConstructor
    @Builder
    @Data
    @NoArgsConstructor
    public static class SignType {
        private UUID id;
        private String name;
    }

}
