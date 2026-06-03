package com.fiap.agricultura.dto.response;

import java.time.LocalDate;

import com.fiap.agricultura.enums.TipoCultura;

public record PlantacaoResponseDTO(

        Long id,
        TipoCultura tipoCultura,
        LocalDate dataPlantio,
        Double areaCultivada

) {
}