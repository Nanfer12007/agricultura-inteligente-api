package com.fiap.agricultura.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fiap.agricultura.dto.request.UsuarioRequestDTO;
import com.fiap.agricultura.dto.response.UsuarioResponseDTO;
import com.fiap.agricultura.entity.Usuario;
import com.fiap.agricultura.enums.Role;
import com.fiap.agricultura.exception.ResourceNotFoundException;
import com.fiap.agricultura.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {

        Usuario usuario = Usuario.builder()
                .nome(dto.nome())
                .email(dto.email())
                .senha(dto.senha())
                .role(Role.AGRICULTOR)
                .build();

        repository.save(usuario);

        return converter(usuario);
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Usuário não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private UsuarioResponseDTO converter(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail());
    }
}