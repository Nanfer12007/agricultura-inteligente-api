package com.fiap.agricultura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.agricultura.entity.Fazenda;

public interface FazendaRepository extends JpaRepository<Fazenda, Long> {

    List<Fazenda> findByNomeContainingIgnoreCase(String nome);

}