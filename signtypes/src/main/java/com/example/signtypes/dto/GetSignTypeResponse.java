package com.example.signtypes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class GetSignTypeResponse {

    private UUID id;
    private String name;
    private char codePrefix;

}
