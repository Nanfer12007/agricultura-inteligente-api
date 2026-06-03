package com.fiap.agricultura.dto.request;

import java.time.LocalDate;

import com.fiap.agricultura.enums.TipoCultura;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PlantacaoRequestDTO(

        @NotNull
        TipoCultura tipoCultura,

        @NotNull
        LocalDate dataPlantio,

        @Positive
        Double areaCultivada,

        @NotNull
        Long fazendaId

) {
}