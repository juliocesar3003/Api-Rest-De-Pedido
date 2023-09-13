package com.stark.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stark.curso.entidades.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
