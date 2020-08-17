package com.llac.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.llac.curso.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
