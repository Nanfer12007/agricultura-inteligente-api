package com.fiap.agricultura.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fiap.agricultura.dto.request.PlantacaoRequestDTO;
import com.fiap.agricultura.dto.response.PlantacaoResponseDTO;
import com.fiap.agricultura.entity.Fazenda;
import com.fiap.agricultura.entity.Plantacao;
import com.fiap.agricultura.exception.ResourceNotFoundException;
import com.fiap.agricultura.repository.FazendaRepository;
import com.fiap.agricultura.repository.PlantacaoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlantacaoService {

    private final PlantacaoRepository repository;
    private final FazendaRepository fazendaRepository;

    public PlantacaoResponseDTO criar(PlantacaoRequestDTO dto) {

        Fazenda fazenda = fazendaRepository.findById(dto.fazendaId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Fazenda não encontrada"));

        Plantacao plantacao = Plantacao.builder()
                .tipoCultura(dto.tipoCultura())
                .dataPlantio(dto.dataPlantio())
                .areaCultivada(dto.areaCultivada())
                .fazenda(fazenda)
                .build();

        repository.save(plantacao);

        return converter(plantacao);
    }

    public List<Plantacao> listar() {
        return repository.findAll();
    }

    private PlantacaoResponseDTO converter(Plantacao plantacao) {

        return new PlantacaoResponseDTO(
                plantacao.getId(),
                plantacao.getTipoCultura(),
                plantacao.getDataPlantio(),
                plantacao.getAreaCultivada());
    }
}