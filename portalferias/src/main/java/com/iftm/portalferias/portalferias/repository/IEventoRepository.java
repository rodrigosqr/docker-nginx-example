package com.iftm.portalferias.portalferias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.portalferias.portalferias.entity.Evento;

public interface IEventoRepository extends JpaRepository<Evento, Long> {
	
}