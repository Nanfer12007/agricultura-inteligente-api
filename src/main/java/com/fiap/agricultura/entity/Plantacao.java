package com.fiap.agricultura.entity;

import java.time.LocalDate;
import java.util.List;

import com.fiap.agricultura.enums.TipoCultura;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_plantacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plantacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoCultura tipoCultura;

    private LocalDate dataPlantio;

    private Double areaCultivada;

    @ManyToOne
    @JoinColumn(name = "fazenda_id")
    private Fazenda fazenda;

    @OneToMany(mappedBy = "plantacao")
    private List<DadoSatelital> dadosSatelitais;

    @OneToMany(mappedBy = "plantacao")
    private List<AlertaClimatico> alertas;

    @OneToMany(mappedBy = "plantacao")
    private List<Recomendacao> recomendacoes;
}