package com.fiap.agricultura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.agricultura.entity.Monitoramento;
import com.fiap.agricultura.entity.MonitoramentoId;

public interface MonitoramentoRepository
        extends JpaRepository<Monitoramento, MonitoramentoId> {

}