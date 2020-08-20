package com.llac.curso.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.llac.curso.entidades.Usuario;
import com.llac.curso.repositorios.UsuarioRepositorio;
import com.llac.curso.services.exceptions.DatabaseException;
import com.llac.curso.services.exceptions.RecursoNaoEncontradoException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepositorio repositorio;
	
	public List<Usuario> listar(){
		return repositorio.findAll();
	}

	public Usuario buscarPorId(Long id) {
		Optional<Usuario> usuario = repositorio.findById(id);
		
		//return usuario.get(); // o método get() retorna o objeto do tipo contido no Optional, no caso, tipo Usuario 
		
		return usuario.orElseThrow(() -> new RecursoNaoEncontradoException(id) ); // tenta fazer o get. Caso não exista o usuario, lança uma Exception
	}
	
	public Usuario inserir(Usuario usuario) {
		return repositorio.save(usuario);
	}
	
	public void deletar(Long id) {
		try {
			repositorio.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontradoException(id);

		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Usuario atualizar(Long id, Usuario usuario) {
		try {
			Usuario entidade = repositorio.getOne(id); // getOne instancia um objeto com o id ao invés de consultar no DB por id
			atualizarDados(entidade, usuario);
			
			return repositorio.save(entidade);
			
		} catch (EntityNotFoundException e) {
			throw new RecursoNaoEncontradoException(id);
		}
	}

	private void atualizarDados(Usuario entidade, Usuario usuario) {
		entidade.setNome(usuario.getNome());
		entidade.setEmail(usuario.getEmail());
		entidade.setPhone(usuario.getPhone());
		
	}
}
