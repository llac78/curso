package com.llac.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llac.curso.entidades.Usuario;
import com.llac.curso.repositorios.UsuarioRepositorio;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepositorio repositorio;
	
	public List<Usuario> listar(){
		return repositorio.findAll();
	}

	public Usuario buscarPorId(Long id) {
		Optional<Usuario> usuario = repositorio.findById(id);
		
		return usuario.get(); // o método get() retorna o objeto do tipo contido no Optional, no caso, tipo Usuario 
	}
	
	public Usuario inserir(Usuario usuario) {
		return repositorio.save(usuario);
	}
	
	public void deletar(Long id) {
		repositorio.deleteById(id);
	}
}
