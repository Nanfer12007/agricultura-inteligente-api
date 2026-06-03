package com.fiap.agricultura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.agricultura.entity.DadoSatelital;

public interface DadoSatelitalRepository
        extends JpaRepository<DadoSatelital, Long> {

}