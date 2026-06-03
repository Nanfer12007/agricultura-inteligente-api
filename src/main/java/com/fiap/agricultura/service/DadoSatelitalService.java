package com.fiap.agricultura.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fiap.agricultura.dto.request.DadoSatelitalRequestDTO;
import com.fiap.agricultura.dto.response.DadoSatelitalResponseDTO;
import com.fiap.agricultura.entity.DadoSatelital;
import com.fiap.agricultura.entity.Plantacao;
import com.fiap.agricultura.exception.ResourceNotFoundException;
import com.fiap.agricultura.repository.DadoSatelitalRepository;
import com.fiap.agricultura.repository.PlantacaoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DadoSatelitalService {

    private final DadoSatelitalRepository repository;
    private final PlantacaoRepository plantacaoRepository;

    // CREATE
    public DadoSatelitalResponseDTO criar(
            DadoSatelitalRequestDTO dto) {

        Plantacao plantacao =
                plantacaoRepository.findById(
                        dto.plantacaoId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Plantação não encontrada"));

        DadoSatelital dado = DadoSatelital.builder()
                .temperatura(dto.temperatura())
                .umidadeSolo(dto.umidadeSolo())
                .indiceVegetacao(dto.indiceVegetacao())
                .riscoSeca(dto.riscoSeca())
                .plantacao(plantacao)
                .build();

        dado.setDataColeta(LocalDateTime.now());

        repository.save(dado);

        return new DadoSatelitalResponseDTO(
                dado.getId(),
                dado.getTemperatura(),
                dado.getUmidadeSolo(),
                dado.getIndiceVegetacao(),
                dado.getRiscoSeca());
    }

    // READ ALL
    public List<DadoSatelital> listar() {

        return repository.findAll();
    }

    // READ BY ID
    public DadoSatelital buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Dado satelital não encontrado"));
    }

    // UPDATE
    public DadoSatelital atualizar(
            Long id,
            DadoSatelitalRequestDTO dto) {

        DadoSatelital dado = buscarPorId(id);

        dado.setTemperatura(dto.temperatura());
        dado.setUmidadeSolo(dto.umidadeSolo());
        dado.setIndiceVegetacao(dto.indiceVegetacao());
        dado.setRiscoSeca(dto.riscoSeca());

        if (dto.plantacaoId() != null) {

            Plantacao plantacao =
                    plantacaoRepository.findById(
                            dto.plantacaoId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException(
                                    "Plantação não encontrada"));

            dado.setPlantacao(plantacao);
        }

        return repository.save(dado);
    }

    // DELETE
    public void deletar(Long id) {

        DadoSatelital dado =
                buscarPorId(id);

        repository.delete(dado);
    }
}