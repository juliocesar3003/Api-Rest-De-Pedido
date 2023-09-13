package com.stark.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stark.curso.entidades.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {

}
