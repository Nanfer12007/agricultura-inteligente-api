package com.fiap.agricultura.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coordenada {

    private Double latitude;

    private Double longitude;
}