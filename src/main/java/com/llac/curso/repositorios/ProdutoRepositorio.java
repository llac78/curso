package com.llac.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.llac.curso.entidades.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

}
