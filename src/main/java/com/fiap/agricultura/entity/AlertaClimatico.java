package com.fiap.agricultura.entity;

import java.time.LocalDateTime;

import com.fiap.agricultura.enums.Severidade;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_alerta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertaClimatico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoAlerta;

    @Enumerated(EnumType.STRING)
    private Severidade severidade;

    private String descricao;

    private LocalDateTime dataEmissao;

    @ManyToOne
    @JoinColumn(name = "plantacao_id")
    private Plantacao plantacao;
}