package com.fiap.agricultura.service;

import org.springframework.stereotype.Service;

import com.fiap.agricultura.dto.response.DashboardDTO;
import com.fiap.agricultura.repository.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final FazendaRepository fazendaRepository;
    private final PlantacaoRepository plantacaoRepository;
    private final DadoSatelitalRepository dadoRepository;
    private final AlertaSecaRepository alertaSecaRepository;
    private final AlertaTemperaturaRepository alertaTempRepository;

    public DashboardDTO obterDashboard() {

        Double mediaTemperatura =
                dadoRepository.findAll()
                        .stream()
                        .mapToDouble(d -> d.getTemperatura())
                        .average()
                        .orElse(0);

        Double mediaUmidade =
                dadoRepository.findAll()
                        .stream()
                        .mapToDouble(d -> d.getUmidadeSolo())
                        .average()
                        .orElse(0);

        return new DashboardDTO(
                fazendaRepository.count(),
                plantacaoRepository.count(),
                dadoRepository.count(),
                mediaTemperatura,
                mediaUmidade,
                alertaTempRepository.count(),
                alertaSecaRepository.count()
        );
    }
}