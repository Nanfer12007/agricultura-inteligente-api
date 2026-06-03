package com.fiap.agricultura.dto.response;

public record FazendaResponseDTO(

        Long id,
        String nome,
        Double areaTotal,
        Double latitude,
        Double longitude

) {
}