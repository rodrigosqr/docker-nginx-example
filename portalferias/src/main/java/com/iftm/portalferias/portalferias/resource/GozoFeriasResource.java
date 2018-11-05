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

import com.iftm.portalferias.portalferias.entity.GozoFerias;
import com.iftm.portalferias.portalferias.event.RecursoCriadoEvento;
import com.iftm.portalferias.portalferias.service.GozoFeriasService;


@RestController
@RequestMapping("/gozoferias")
public class GozoFeriasResource {

	@Autowired
	private GozoFeriasService entidadeBO;

	@Autowired
	private ApplicationEventPublisher publicador;

	@GetMapping
	public List<GozoFerias> listar() {
		return entidadeBO.buscarTodos();
	}
	
	@PostMapping
	public ResponseEntity<GozoFerias> salvar(@Valid @RequestBody GozoFerias entidade, HttpServletResponse response) {
		GozoFerias entidadeSalvo = entidadeBO.salvar(entidade);
		publicador.publishEvent(new RecursoCriadoEvento(this, response, entidadeSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(entidadeSalvo);
	}

	@GetMapping("/{id}")
	public ResponseEntity<GozoFerias> buscarPorId(@PathVariable Long id) {
		GozoFerias entidade = entidadeBO.buscarPorId(id);
		return entidade != null ? ResponseEntity.ok(entidade) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		entidadeBO.excluir(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<GozoFerias> atualizarPorId(@PathVariable Long id, @Valid @RequestBody GozoFerias entidade) {
		return ResponseEntity.ok(entidadeBO.atualizar(id, entidade));
	}

}