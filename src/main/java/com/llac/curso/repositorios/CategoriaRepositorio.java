package com.llac.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.llac.curso.entidades.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

}
