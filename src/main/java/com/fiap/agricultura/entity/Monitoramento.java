package com.fiap.agricultura.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_monitoramento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Monitoramento {

    @EmbeddedId
    private MonitoramentoId id;

    private Double indiceSaude;

    private Double produtividadePrevista;
}