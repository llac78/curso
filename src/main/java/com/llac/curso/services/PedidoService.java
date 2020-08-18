package com.llac.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llac.curso.entidades.Pedido;
import com.llac.curso.repositorios.PedidoRepositorio;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepositorio repositorio;
	
	public List<Pedido> listar(){
		return repositorio.findAll();
	}

	public Pedido buscarPorId(Long id) {
		Optional<Pedido> pedido = repositorio.findById(id);
		
		return pedido.get(); // o método get() retorna o objeto do tipo contido no Optional, no caso, tipo Pedido 
	}
}
