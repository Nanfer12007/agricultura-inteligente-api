package com.fiap.agricultura.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_dado_satelital")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DadoSatelital extends SensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double temperatura;

    private Double umidadeSolo;

    private Double indiceVegetacao;

    private Double riscoSeca;

    @ManyToOne
    @JoinColumn(name = "plantacao_id")
    private Plantacao plantacao;
}