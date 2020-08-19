package com.llac.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.llac.curso.entidades.ItemPedido;

public interface ItemPedidoRepositorio extends JpaRepository<ItemPedido, Long> {

}
