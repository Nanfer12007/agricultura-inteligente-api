package com.fiap.agricultura.dto.response;

import com.fiap.agricultura.enums.Severidade;

public record AlertaClimaticoResponseDTO(

        Long id,
        String tipoAlerta,
        Severidade severidade,
        String descricao

) {
}