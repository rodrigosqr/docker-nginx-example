package com.iftm.portalferias.portalferias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.portalferias.portalferias.entity.Funcionario;

public interface IFuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
}