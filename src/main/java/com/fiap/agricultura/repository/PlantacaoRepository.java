package com.fiap.agricultura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.agricultura.entity.Plantacao;
import com.fiap.agricultura.enums.TipoCultura;

public interface PlantacaoRepository extends JpaRepository<Plantacao, Long> {

    List<Plantacao> findByTipoCultura(TipoCultura tipoCultura);

}