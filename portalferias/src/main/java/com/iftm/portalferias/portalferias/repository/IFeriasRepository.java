package com.iftm.portalferias.portalferias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.portalferias.portalferias.entity.Ferias;
import com.iftm.portalferias.portalferias.entity.Funcionario;

public interface IFeriasRepository extends JpaRepository<Ferias, Long> {
	
	public List<Ferias> findByFuncionario(Funcionario funcionario);
	
}