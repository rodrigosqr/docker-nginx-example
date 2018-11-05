package com.iftm.portalferias.portalferias.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iftm.portalferias.portalferias.entity.FuncionarioEvento;
import com.iftm.portalferias.portalferias.repository.IFuncionarioEventoRepository;

@Service
public class FuncionarioEventoService {

	@Autowired
	private IFuncionarioEventoRepository repository;

	public FuncionarioEvento salvar(FuncionarioEvento funcionarioEvento) {
		return repository.save(funcionarioEvento);
	}

	public void excluir(Long id) {
		repository.delete(new FuncionarioEvento(id));
	}

	public List<FuncionarioEvento> buscarTodos() {
		return repository.findAll();
	}

	public FuncionarioEvento buscarPorId(Long id) {
		return repository.findOne(id);
	}

	public FuncionarioEvento atualizar(Long id, FuncionarioEvento grupo) {
		FuncionarioEvento entidadeSalvo = buscarPorId(id);
		BeanUtils.copyProperties(grupo, entidadeSalvo, "id");
		return salvar(grupo);
	}
}
