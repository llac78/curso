package com.llac.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llac.curso.entidades.Categoria;
import com.llac.curso.repositorios.CategoriaRepositorio;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepositorio repositorio;
	
	public List<Categoria> listar(){
		return repositorio.findAll();
	}

	public Categoria buscarPorId(Long id) {
		Optional<Categoria> categoria = repositorio.findById(id);
		
		return categoria.get(); // o método get() retorna o objeto do tipo contido no Optional, no caso, tipo Categoria 
	}
}
