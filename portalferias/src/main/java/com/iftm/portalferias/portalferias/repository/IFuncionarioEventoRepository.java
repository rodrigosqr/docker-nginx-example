package com.iftm.portalferias.portalferias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.portalferias.portalferias.entity.FuncionarioEvento;

public interface IFuncionarioEventoRepository extends JpaRepository<FuncionarioEvento, Long> {
	
}