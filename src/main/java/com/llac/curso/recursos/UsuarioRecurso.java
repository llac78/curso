package com.llac.curso.recursos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.llac.curso.entidades.Usuario;
import com.llac.curso.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecurso { //Controller
	
	@Autowired
	private UsuarioService service;

	@GetMapping
	public ResponseEntity<List<Usuario>> listar(){
		List<Usuario> lista = service.listar();
		
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){ // @PathVariable para aceitar o {id} como parâmetro
		Usuario usuario = service.buscarPorId(id);
		
		return ResponseEntity.ok().body(usuario);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> inserir(
			// annotation para informar vai chegar no formato JSON na hora de fazer a requisição e vai ser desserializado para um objeto Usuario
			@RequestBody Usuario usuario){  
		usuario = service.inserir(usuario);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(usuario.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(usuario);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		service.deletar(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> atualizar(
			@PathVariable Long id, 
			@RequestBody Usuario usuario){
		
		usuario = service.atualizar(id, usuario);
		
		return ResponseEntity.ok().body(usuario);
	}
	
	
}
