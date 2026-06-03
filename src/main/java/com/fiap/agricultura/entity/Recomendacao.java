package com.fiap.agricultura.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_recomendacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recomendacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;

    private String prioridade;

    private LocalDateTime dataGeracao;

    @ManyToOne
    @JoinColumn(name = "plantacao_id")
    private Plantacao plantacao;
}