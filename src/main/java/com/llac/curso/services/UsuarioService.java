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
	
	public Usuario atualizar(Long id, Usuario usuario) {
		Usuario entidade = repositorio.getOne(id); // getOne instancia um objeto com o id ao invés de consultar no DB por id
		atualizarDados(entidade, usuario);
		
		return repositorio.save(entidade);
	}

	private void atualizarDados(Usuario entidade, Usuario usuario) {
		entidade.setNome(usuario.getNome());
		entidade.setEmail(usuario.getEmail());
		entidade.setPhone(usuario.getPhone());
		
	}
}
