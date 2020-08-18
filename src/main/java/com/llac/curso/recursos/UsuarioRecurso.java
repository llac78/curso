package com.llac.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
