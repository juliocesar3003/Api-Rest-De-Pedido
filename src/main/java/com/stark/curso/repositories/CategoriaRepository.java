package com.stark.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stark.curso.entidades.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
