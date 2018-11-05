package com.iftm.portalferias.portalferias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.portalferias.portalferias.entity.Cargo;

public interface ICargoRepository extends JpaRepository<Cargo, Long> {
	
}