package com.fiap.agricultura.dto.response;

public record DadoSatelitalResponseDTO(

        Long id,
        Double temperatura,
        Double umidadeSolo,
        Double indiceVegetacao,
        Double riscoSeca

) {
}