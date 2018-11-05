package com.iftm.portalferias.portalferias.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iftm.portalferias.portalferias.entity.Cargo;
import com.iftm.portalferias.portalferias.repository.ICargoRepository;


@Service
public class CargoService {

	@Autowired
	private ICargoRepository repository;

	public Cargo salvar(Cargo cargo) {
		return repository.save(cargo);
	}

	public void excluir(Long id) {
		repository.delete(new Cargo(id));
	}

	public List<Cargo> buscarTodos() {
		return repository.findAll();
	}

	public Cargo buscarPorId(Long id) {
		return repository.findOne(id);
	}

	public Cargo atualizar(Long id, Cargo grupo) {
		Cargo entidadeSalvo = buscarPorId(id);
		BeanUtils.copyProperties(grupo, entidadeSalvo, "id");
		return salvar(grupo);
	}
}
