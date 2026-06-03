package com.fiap.agricultura.dto.request;

import com.fiap.agricultura.enums.Severidade;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlertaClimaticoRequestDTO(

        @NotBlank
        String tipoAlerta,

        @NotNull
        Severidade severidade,

        @NotBlank
        String descricao,

        @NotNull
        Long plantacaoId

) {
}