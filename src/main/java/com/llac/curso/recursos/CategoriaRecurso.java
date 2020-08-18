package com.llac.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.llac.curso.entidades.Categoria;
import com.llac.curso.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaRecurso { //Controller
	
	@Autowired
	private CategoriaService service;

	@GetMapping
	public ResponseEntity<List<Categoria>> listar(){
		List<Categoria> lista = service.listar();
		
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id){ // @PathVariable para aceitar o {id} como parâmetro
		Categoria categoria = service.buscarPorId(id);
		
		return ResponseEntity.ok().body(categoria);
	}
}
