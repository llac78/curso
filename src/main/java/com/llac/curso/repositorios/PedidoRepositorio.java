package com.llac.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.llac.curso.entidades.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {

}
