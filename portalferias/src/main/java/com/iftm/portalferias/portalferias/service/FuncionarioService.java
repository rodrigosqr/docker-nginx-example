package com.iftm.portalferias.portalferias.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iftm.portalferias.portalferias.entity.Funcionario;
import com.iftm.portalferias.portalferias.repository.IFuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private IFuncionarioRepository repository;

	public Funcionario salvar(Funcionario funcionario) {
		return repository.save(funcionario);
	}

	public void excluir(Long id) {
		repository.delete(new Funcionario(id));
	}

	public List<Funcionario> buscarTodos() {
		return repository.findAll();
	}

	public Funcionario buscarPorId(Long id) {
		return repository.findOne(id);
	}

	public Funcionario atualizar(Long id, Funcionario grupo) {
		Funcionario entidadeSalvo = buscarPorId(id);
		BeanUtils.copyProperties(grupo, entidadeSalvo, "id");
		return salvar(grupo);
	}
}
