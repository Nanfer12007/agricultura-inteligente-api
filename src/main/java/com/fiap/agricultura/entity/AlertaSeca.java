package com.fiap.agricultura.entity;

import jakarta.persistence.Entity;

@Entity
public class AlertaSeca extends Alerta {

    public Double getNivelRisco() {
		return nivelRisco;
	}

	public void setNivelRisco(Double nivelRisco) {
		this.nivelRisco = nivelRisco;
	}

	private Double nivelRisco;
}