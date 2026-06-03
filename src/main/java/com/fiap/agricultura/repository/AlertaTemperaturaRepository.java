package com.fiap.agricultura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.agricultura.entity.AlertaTemperatura;

public interface AlertaTemperaturaRepository
        extends JpaRepository<AlertaTemperatura, Long> {
}