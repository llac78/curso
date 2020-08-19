package com.llac.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llac.curso.entidades.Produto;
import com.llac.curso.repositorios.ProdutoRepositorio;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepositorio repositorio;
	
	public List<Produto> listar(){
		return repositorio.findAll();
	}

	public Produto buscarPorId(Long id) {
		Optional<Produto> produto = repositorio.findById(id);
		
		return produto.get(); // o método get() retorna o objeto do tipo contido no Optional, no caso, tipo Produto 
	}
}
