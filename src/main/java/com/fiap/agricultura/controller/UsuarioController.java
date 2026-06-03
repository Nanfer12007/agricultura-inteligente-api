package com.fiap.agricultura.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fiap.agricultura.dto.request.UsuarioRequestDTO;
import com.fiap.agricultura.dto.response.UsuarioResponseDTO;
import com.fiap.agricultura.entity.Usuario;
import com.fiap.agricultura.service.UsuarioService;

import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/usuarios")
@Tag(
	    name = "Usuários",
	    description = "Gerenciamento de usuários da plataforma"
	)
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(
    	    summary = "Cadastrar usuário",
    	    description = "Realiza o cadastro de um novo agricultor"
    	)
    public ResponseEntity<UsuarioResponseDTO> criar(
            @RequestBody @Valid UsuarioRequestDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criar(dto));
    }

    @GetMapping
    @Operation(
    	    summary = "Listar usuários",
    	    description = "Retorna todos os usuários cadastrados"
    	)

    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}