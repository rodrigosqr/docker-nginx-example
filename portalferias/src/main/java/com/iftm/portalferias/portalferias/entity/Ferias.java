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
@Table(name = "tb_ferias")
public class Ferias implements Serializable {

	private static final long serialVersionUID = 201806280244L;
	@Id
	@GeneratedValue
	@Column(name = "cod_ferias", nullable = false)
	private Long id;

	@Column(name = "dt_inicioaquisicao", nullable = false)
	@NotNull(message = "Data de início do período aquisitivo é obrigatório.")
	private LocalDate dataInicioAquisicao;

	@Column(name = "dt_finalaquisicao", nullable = false)
	@NotNull(message = "Data final do período aquisitivo é obrigatório.")
	private LocalDate dataFinalAquisicao;

	@ManyToOne
	@JoinColumn(name = "cod_funcionario", referencedColumnName="cod_Funcionario")
	@NotNull(message = "Funcionário é obrigatório.")
	private Funcionario funcionario;

	public Ferias() {

	}
	
	public Ferias(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;

	}

	public LocalDate getDataInicioAquisicao() {
		return dataInicioAquisicao;
	}

	public void setDataInicioAquisicao(LocalDate dataInicioAquisicao) {
		this.dataInicioAquisicao = dataInicioAquisicao;
	}

	public LocalDate getDataFinalAquisicao() {
		return dataFinalAquisicao;
	}

	public void setDataFinalAquisicao(LocalDate dataFinalAquisicao) {
		this.dataFinalAquisicao = dataFinalAquisicao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataFinalAquisicao == null) ? 0 : dataFinalAquisicao.hashCode());
		result = prime * result + ((dataInicioAquisicao == null) ? 0 : dataInicioAquisicao.hashCode());
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
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
		Ferias other = (Ferias) obj;
		if (dataFinalAquisicao == null) {
			if (other.dataFinalAquisicao != null)
				return false;
		} else if (!dataFinalAquisicao.equals(other.dataFinalAquisicao))
			return false;
		if (dataInicioAquisicao == null) {
			if (other.dataInicioAquisicao != null)
				return false;
		} else if (!dataInicioAquisicao.equals(other.dataInicioAquisicao))
			return false;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		return true;
	}

}
