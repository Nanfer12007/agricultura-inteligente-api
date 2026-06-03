package com.fiap.agricultura.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fiap.agricultura.dto.request.FazendaRequestDTO;
import com.fiap.agricultura.dto.response.FazendaResponseDTO;
import com.fiap.agricultura.entity.Fazenda;
import com.fiap.agricultura.service.FazendaService;

import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/fazendas")
@Tag(
	    name = "Usuários",
	    description = "Gerenciamento de usuários da plataforma"
	)
public class FazendaController {

    private final FazendaService service;

    public FazendaController(FazendaService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(
    	    summary = "Cadastrar usuário",
    	    description = "Realiza o cadastro de um novo agricultor"
    	)
    public ResponseEntity<FazendaResponseDTO> criar(
            @RequestBody @Valid FazendaRequestDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criar(dto));
    }

    @GetMapping
    @Operation(
    	    summary = "Listar usuários",
    	    description = "Retorna todos os usuários cadastrados"
    	)
    public ResponseEntity<List<Fazenda>> listar() {

        return ResponseEntity.ok(service.listar());
    }
}