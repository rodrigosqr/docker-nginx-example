package com.iftm.portalferias.portalferias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.portalferias.portalferias.entity.GozoFerias;

public interface IGozoFeriasRepository extends JpaRepository<GozoFerias, Long> {
	
}