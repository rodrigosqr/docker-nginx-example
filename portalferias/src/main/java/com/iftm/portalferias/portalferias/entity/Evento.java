package com.iftm.portalferias.portalferias.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "tb_evento")
public class Evento implements Serializable {
	
	private static final long serialVersionUID = 201806270112L;
	
	@Id
	@Column(name = "cod_Evento", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Descrição é obrigatório.")
	@Column(name = "ds_Evento", unique = true, nullable = false)
	private String descricao;

	@NotBlank(message = "Tipo de evento é obrigatório.")
	@Column(name = "tipoevento", unique = true, nullable = false)
	private String tipoEvento;
	
	public Evento() {
	}
	
	public Evento(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((tipoEvento == null) ? 0 : tipoEvento.hashCode());
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
		Evento other = (Evento) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (tipoEvento == null) {
			if (other.tipoEvento != null)
				return false;
		} else if (!tipoEvento.equals(other.tipoEvento))
			return false;
		return true;
	}
}