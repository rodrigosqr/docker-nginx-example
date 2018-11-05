package com.iftm.portalferias.portalferias.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_Gozoferias")
public class GozoFerias implements Serializable {

	private static final long serialVersionUID = 201806280257L;
	@Id
	@GeneratedValue
	@Column(name = "cod_gozoferias", nullable = false)
	private Long id;

	@Column(name = "dt_iniciogozo", nullable = false)
	@NotNull(message = "Data início de gozo de férias é obrigatório.")
	private LocalDate dataInicioGozo;

	@Column(name = "dt_finalgozo", nullable = false)
	@NotNull(message = "Data final de gozo de férias é obrigatório.")
	private LocalDate dataFinalGozo;

	@Column(name = "dt_pagamentoferias", nullable = true)
	private LocalDate dataPagamentoFerias;

	@ManyToOne
	@JoinColumn(name = "cod_ferias", referencedColumnName="cod_Ferias")
	@NotNull(message = "Férias é obrigatório.")
	private Ferias ferias;

	public GozoFerias() {
	}

	public GozoFerias(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataInicioGozo() {
		return dataInicioGozo;
	}

	public void setDataInicioGozo(LocalDate dataInicioGozo) {
		this.dataInicioGozo = dataInicioGozo;
	}

	public LocalDate getDataFinalGozo() {
		return dataFinalGozo;
	}

	public void setDataFinalGozo(LocalDate dataFinalGozo) {
		this.dataFinalGozo = dataFinalGozo;
	}

	public Ferias getFerias() {
		return ferias;
	}

	public void setFerias(Ferias ferias) {
		this.ferias = ferias;
	}

	public LocalDate getDataPagamentoFerias() {
		return dataPagamentoFerias;
	}

	public void setDataPagamentoFerias(LocalDate dataPagamentoFerias) {
		this.dataPagamentoFerias = dataPagamentoFerias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataFinalGozo == null) ? 0 : dataFinalGozo.hashCode());
		result = prime * result + ((dataInicioGozo == null) ? 0 : dataInicioGozo.hashCode());
		result = prime * result + ((dataPagamentoFerias == null) ? 0 : dataPagamentoFerias.hashCode());
		result = prime * result + ((ferias == null) ? 0 : ferias.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GozoFerias other = (GozoFerias) obj;
		if (dataFinalGozo == null) {
			if (other.dataFinalGozo != null)
				return false;
		} else if (!dataFinalGozo.equals(other.dataFinalGozo))
			return false;
		if (dataInicioGozo == null) {
			if (other.dataInicioGozo != null)
				return false;
		} else if (!dataInicioGozo.equals(other.dataInicioGozo))
			return false;
		if (dataPagamentoFerias == null) {
			if (other.dataPagamentoFerias != null)
				return false;
		} else if (!dataPagamentoFerias.equals(other.dataPagamentoFerias))
			return false;
		if (ferias == null) {
			if (other.ferias != null)
				return false;
		} else if (!ferias.equals(other.ferias))
			return false;
		return true;
	}
	
}
