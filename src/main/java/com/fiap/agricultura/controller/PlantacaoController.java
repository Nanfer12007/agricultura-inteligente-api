package com.fiap.agricultura.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fiap.agricultura.dto.request.PlantacaoRequestDTO;
import com.fiap.agricultura.dto.response.PlantacaoResponseDTO;
import com.fiap.agricultura.entity.Plantacao;
import com.fiap.agricultura.service.PlantacaoService;

import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/plantacoes")
@Tag(
	    name = "Usuários",
	    description = "Gerenciamento de usuários da plataforma"
	)
public class PlantacaoController {

    private final PlantacaoService service;

    public PlantacaoController(PlantacaoService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(
    	    summary = "Cadastrar usuário",
    	    description = "Realiza o cadastro de um novo agricultor"
    	)
    public ResponseEntity<PlantacaoResponseDTO> criar(
            @RequestBody @Valid PlantacaoRequestDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criar(dto));
    }

    @GetMapping
    @Operation(
    	    summary = "Listar usuários",
    	    description = "Retorna todos os usuários cadastrados"
    	)
    public ResponseEntity<List<Plantacao>> listar() {

        return ResponseEntity.ok(service.listar());
    }
}