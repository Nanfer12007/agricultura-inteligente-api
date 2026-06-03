package com.fiap.agricultura.dto.request;

import jakarta.validation.constraints.NotNull;

public record DadoSatelitalRequestDTO(

        @NotNull
        Double temperatura,

        @NotNull
        Double umidadeSolo,

        @NotNull
        Double indiceVegetacao,

        @NotNull
        Double riscoSeca,

        @NotNull
        Long plantacaoId

) {
}