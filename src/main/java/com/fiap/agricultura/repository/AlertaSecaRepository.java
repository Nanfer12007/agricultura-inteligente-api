package com.fiap.agricultura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.agricultura.entity.AlertaSeca;

public interface AlertaSecaRepository
        extends JpaRepository<AlertaSeca, Long> {
}