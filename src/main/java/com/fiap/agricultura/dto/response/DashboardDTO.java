package com.fiap.agricultura.dto.response;

public record DashboardDTO(

        Long totalFazendas,
        Long totalPlantacoes,
        Long totalDadosSatelitais,
        Double mediaTemperatura,
        Double mediaUmidade,
        Long alertasTemperatura,
        Long alertasSeca
) {
}