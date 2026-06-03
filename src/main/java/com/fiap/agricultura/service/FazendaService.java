package com.fiap.agricultura.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fiap.agricultura.dto.request.FazendaRequestDTO;
import com.fiap.agricultura.dto.response.FazendaResponseDTO;
import com.fiap.agricultura.entity.Coordenada;
import com.fiap.agricultura.entity.Fazenda;
import com.fiap.agricultura.entity.Usuario;
import com.fiap.agricultura.exception.ResourceNotFoundException;
import com.fiap.agricultura.repository.FazendaRepository;
import com.fiap.agricultura.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FazendaService {

    private final FazendaRepository fazendaRepository;
    private final UsuarioRepository usuarioRepository;

    public FazendaResponseDTO criar(FazendaRequestDTO dto) {

        Usuario proprietario = usuarioRepository.findById(dto.proprietarioId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Usuário não encontrado"));

        Fazenda fazenda = Fazenda.builder()
                .nome(dto.nome())
                .areaTotal(dto.areaTotal())
                .coordenada(new Coordenada(
                        dto.latitude(),
                        dto.longitude()))
                .proprietario(proprietario)
                .build();

        fazendaRepository.save(fazenda);

        return converter(fazenda);
    }

    public List<Fazenda> listar() {
        return fazendaRepository.findAll();
    }

    private FazendaResponseDTO converter(Fazenda fazenda) {

        return new FazendaResponseDTO(
                fazenda.getId(),
                fazenda.getNome(),
                fazenda.getAreaTotal(),
                fazenda.getCoordenada().getLatitude(),
                fazenda.getCoordenada().getLongitude());
    }
}