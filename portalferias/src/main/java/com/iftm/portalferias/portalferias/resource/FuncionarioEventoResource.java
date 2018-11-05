package com.iftm.portalferias.portalferias.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iftm.portalferias.portalferias.entity.FuncionarioEvento;
import com.iftm.portalferias.portalferias.event.RecursoCriadoEvento;
import com.iftm.portalferias.portalferias.service.FuncionarioEventoService;


@RestController
@RequestMapping("/funcionarioevento")
public class FuncionarioEventoResource {

	@Autowired
	private FuncionarioEventoService entidadeBO;

	@Autowired
	private ApplicationEventPublisher publicador;

	@GetMapping
	public List<FuncionarioEvento> listar() {
		return entidadeBO.buscarTodos();
	}
	
	@PostMapping
	public ResponseEntity<FuncionarioEvento> salvar(@Valid @RequestBody FuncionarioEvento entidade, HttpServletResponse response) {
		FuncionarioEvento entidadeSalvo = entidadeBO.salvar(entidade);
		publicador.publishEvent(new RecursoCriadoEvento(this, response, entidadeSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(entidadeSalvo);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FuncionarioEvento> buscarPorId(@PathVariable Long id) {
		FuncionarioEvento entidade = entidadeBO.buscarPorId(id);
		return entidade != null ? ResponseEntity.ok(entidade) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		entidadeBO.excluir(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<FuncionarioEvento> atualizarPorId(@PathVariable Long id, @Valid @RequestBody FuncionarioEvento entidade) {
		return ResponseEntity.ok(entidadeBO.atualizar(id, entidade));
	}

}