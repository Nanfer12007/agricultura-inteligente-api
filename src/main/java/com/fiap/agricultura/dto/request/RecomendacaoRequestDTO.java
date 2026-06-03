package com.fiap.agricultura.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RecomendacaoRequestDTO(

        @NotBlank
        String mensagem,

        @NotBlank
        String prioridade,

        @NotNull
        Long plantacaoId

) {
}