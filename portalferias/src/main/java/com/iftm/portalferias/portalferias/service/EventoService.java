package com.iftm.portalferias.portalferias.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iftm.portalferias.portalferias.entity.Evento;
import com.iftm.portalferias.portalferias.repository.IEventoRepository;

@Service
public class EventoService {

	@Autowired
	private IEventoRepository repository;

	public Evento salvar(Evento evento) {
		return repository.save(evento);
	}

	public void excluir(Long id) {
		repository.delete(new Evento(id));
	}

	public List<Evento> buscarTodos() {
		return repository.findAll();
	}

	public Evento buscarPorId(Long id) {
		return repository.findOne(id);
	}

	public Evento atualizar(Long id, Evento grupo) {
		Evento entidadeSalvo = buscarPorId(id);
		BeanUtils.copyProperties(grupo, entidadeSalvo, "id");
		return salvar(grupo);
	}
}
