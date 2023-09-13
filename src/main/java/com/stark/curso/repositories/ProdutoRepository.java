package com.stark.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stark.curso.entidades.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
