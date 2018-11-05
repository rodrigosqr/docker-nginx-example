package com.iftm.portalferias.portalferias.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iftm.portalferias.portalferias.entity.Ferias;
import com.iftm.portalferias.portalferias.entity.Funcionario;
import com.iftm.portalferias.portalferias.exception.RegraNegocioExcecao;
import com.iftm.portalferias.portalferias.repository.IFeriasRepository;

@Service
public class FeriasService {

	@Autowired
	private IFeriasRepository repository;

	public Ferias salvar(Ferias ferias) {
		validarPeriodoAquisitivo(ferias);
		return repository.save(ferias);
	}

	public void excluir(Long id) {
		repository.delete(new Ferias(id));
	}

	public List<Ferias> buscarTodos() {
		return repository.findAll();
	}

	public Ferias buscarPorId(Long id) {
		return repository.findOne(id);
	}

	public List<Ferias> buscarPorFuncionario(Long id) {
		return repository.findByFuncionario(new Funcionario(id));
	}

	public Ferias atualizar(Long id, Ferias ferias) {
		Ferias entidadeSalvo = buscarPorId(id);
		BeanUtils.copyProperties(ferias, entidadeSalvo, "id");
		return salvar(ferias);
	}

	private void validarPeriodoAquisitivo(Ferias ferias) {	
		LocalDate dataFinalCorreta = ferias.getDataInicioAquisicao().plusYears(1).minusDays(1);
		if (!dataFinalCorreta.isEqual(ferias.getDataFinalAquisicao())) {
			throw new RegraNegocioExcecao("A data final do período aquisitivo deve ser: "
					+ dataFinalCorreta.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		}
	}
}
