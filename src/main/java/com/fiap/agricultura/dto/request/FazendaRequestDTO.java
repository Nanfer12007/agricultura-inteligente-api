package com.fiap.agricultura.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record FazendaRequestDTO(

        @NotBlank
        String nome,

        @Positive
        Double areaTotal,

        @NotNull
        Double latitude,

        @NotNull
        Double longitude,

        @NotNull
        Long proprietarioId

) {
}