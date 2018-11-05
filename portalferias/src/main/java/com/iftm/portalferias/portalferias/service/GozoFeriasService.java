package com.iftm.portalferias.portalferias.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iftm.portalferias.portalferias.entity.GozoFerias;
import com.iftm.portalferias.portalferias.repository.IGozoFeriasRepository;

@Service
public class GozoFeriasService {

	@Autowired
	private IGozoFeriasRepository repository;

	public GozoFerias salvar(GozoFerias gozoFerias) {
		return repository.save(gozoFerias);
	}

	public void excluir(Long id) {
		repository.delete(new GozoFerias(id));
	}

	public List<GozoFerias> buscarTodos() {
		return repository.findAll();
	}

	public GozoFerias buscarPorId(Long id) {
		return repository.findOne(id);
	}

	public GozoFerias atualizar(Long id, GozoFerias grupo) {
		GozoFerias entidadeSalvo = buscarPorId(id);
		BeanUtils.copyProperties(grupo, entidadeSalvo, "id");
		return salvar(grupo);
	}
}
