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
@Table(name = "tb_Funcionarioevento")
public class FuncionarioEvento implements Serializable {

	private static final long serialVersionUID = 201806280241L;
	@Id
	@GeneratedValue
	@Column(name = "cod_funcionarioevento", nullable = false)
	private Long id;

	@Column(name = "dt_inicioevento", nullable = true)
	@NotNull(message = "Data de inicio do evento é obrigatório.")
	private LocalDate dataInicioEvento;

	@Column(name = "dt_finalevento", nullable = true)
	@NotNull(message = "Data de final do evento é obrigatório.")
	private LocalDate dataFinalEvento;

	@Column(name = "des_observacao", nullable = true)
	private String observacao;

	@ManyToOne
	@JoinColumn(name = "cod_funcionario", referencedColumnName = "cod_Funcionario")
	@NotNull(message = "Funcinário é obrigatório.")
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "cod_evento", referencedColumnName = "cod_Evento")
	@NotNull(message = "Evento é obrigatório.")
	private Evento evento;

	public FuncionarioEvento() {

	}

	public FuncionarioEvento(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataInicioEvento() {
		return dataInicioEvento;
	}

	public void setDataInicioEvento(LocalDate dataInicioEvento) {
		this.dataInicioEvento = dataInicioEvento;
	}

	public LocalDate getDataFinalEvento() {
		return dataFinalEvento;
	}

	public void setDataFinalEvento(LocalDate dataFinalEvento) {
		this.dataFinalEvento = dataFinalEvento;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataFinalEvento == null) ? 0 : dataFinalEvento.hashCode());
		result = prime * result + ((dataInicioEvento == null) ? 0 : dataInicioEvento.hashCode());
		result = prime * result + ((evento == null) ? 0 : evento.hashCode());
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
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
		FuncionarioEvento other = (FuncionarioEvento) obj;
		if (dataFinalEvento == null) {
			if (other.dataFinalEvento != null)
				return false;
		} else if (!dataFinalEvento.equals(other.dataFinalEvento))
			return false;
		if (dataInicioEvento == null) {
			if (other.dataInicioEvento != null)
				return false;
		} else if (!dataInicioEvento.equals(other.dataInicioEvento))
			return false;
		if (evento == null) {
			if (other.evento != null)
				return false;
		} else if (!evento.equals(other.evento))
			return false;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		return true;
	}

}
