package com.llac.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.llac.curso.entidades.Produto;
import com.llac.curso.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoRecurso { //Controller
	
	@Autowired
	private ProdutoService service;

	@GetMapping
	public ResponseEntity<List<Produto>> listar(){
		List<Produto> lista = service.listar();
		
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id){ // @PathVariable para aceitar o {id} como parâmetro
		Produto produto = service.buscarPorId(id);
		
		return ResponseEntity.ok().body(produto);
	}
}
