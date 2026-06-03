package com.fiap.agricultura.entity;

import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;
import lombok.*;

@MappedSuperclass
@Getter
@Setter
public abstract class SensorData {

    private LocalDateTime dataColeta;

}