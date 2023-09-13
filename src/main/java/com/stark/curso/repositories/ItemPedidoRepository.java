package com.stark.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stark.curso.entidades.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

}
