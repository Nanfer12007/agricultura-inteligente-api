package com.fiap.agricultura.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fiap.agricultura.dto.request.DadoSatelitalRequestDTO;
import com.fiap.agricultura.entity.DadoSatelital;
import com.fiap.agricultura.service.DadoSatelitalService;

import jakarta.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/dados-satelitais")
public class DadoSatelitalController {

    private final DadoSatelitalService service;

    public DadoSatelitalController(
            DadoSatelitalService service) {

        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> criar(
            @RequestBody @Valid DadoSatelitalRequestDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criar(dto));
    }

    @GetMapping
    public CollectionModel<EntityModel<DadoSatelital>> listar() {

        List<EntityModel<DadoSatelital>> dados =
                service.listar()
                        .stream()
                        .map(dado -> EntityModel.of(
                                dado,
                                linkTo(methodOn(
                                        DadoSatelitalController.class)
                                        .buscar(dado.getId()))
                                        .withSelfRel()))
                        .toList();

        return CollectionModel.of(
                dados,
                linkTo(methodOn(
                        DadoSatelitalController.class)
                        .listar())
                        .withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<DadoSatelital> buscar(
            @PathVariable Long id) {

        DadoSatelital dado =
                service.buscarPorId(id);

        return EntityModel.of(
                dado,
                linkTo(methodOn(
                        DadoSatelitalController.class)
                        .buscar(id))
                        .withSelfRel(),
                linkTo(methodOn(
                        DadoSatelitalController.class)
                        .listar())
                        .withRel("todos"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadoSatelital> atualizar(
            @PathVariable Long id,
            @RequestBody DadoSatelitalRequestDTO dto) {

        return ResponseEntity.ok(
                service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}