package com.fiap.agricultura.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_fazenda")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fazenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double areaTotal;

    @Embedded
    private Coordenada coordenada;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario proprietario;

    @OneToMany(mappedBy = "fazenda")
    private List<Plantacao> plantacoes;
}