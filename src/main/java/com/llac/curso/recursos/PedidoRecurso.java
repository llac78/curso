package com.llac.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.llac.curso.entidades.Pedido;
import com.llac.curso.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoRecurso { //Controller
	
	@Autowired
	private PedidoService service;

	@GetMapping
	public ResponseEntity<List<Pedido>> listar(){
		List<Pedido> lista = service.listar();
		
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id){ // @PathVariable para aceitar o {id} como parâmetro
		Pedido pedido = service.buscarPorId(id);
		
		return ResponseEntity.ok().body(pedido);
	}
}
