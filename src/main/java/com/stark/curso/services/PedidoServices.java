package com.stark.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stark.curso.entidades.Pedido;
import com.stark.curso.repositories.PedidoRepository;

@Service
public class PedidoServices {

	@Autowired
	private PedidoRepository repository;
	
	public List<Pedido> findAll(){
		return repository.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.get();
	}
}
