package com.fiap.agricultura.entity;

import jakarta.persistence.Entity;

@Entity
public class AlertaTemperatura extends Alerta {

    public Double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}

	private Double temperatura;
}