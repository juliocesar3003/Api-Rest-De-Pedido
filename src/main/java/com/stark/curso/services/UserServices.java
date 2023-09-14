package com.stark.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.stark.curso.entidades.Usuario;
import com.stark.curso.repositories.UserRepository;
import com.stark.curso.services.exception.DataBaseException;
import com.stark.curso.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServices {

	@Autowired
	private UserRepository repository;
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Usuario insert(Usuario obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
	 try {
		   repository.deleteById(id);
	     }
	 catch(EmptyResultDataAccessException e) {
		 throw new ResourceNotFoundException(id);
	 }
	 catch(DataIntegrityViolationException e) {
		 throw new DataBaseException(e.getMessage());
	 }
	}
	
	public Usuario update(Long id, Usuario obj) {
	 try {	
		Usuario entidade = repository.getReferenceById(id);
		updateData(entidade,obj);
		return repository.save(entidade);
	 }
	catch(EntityNotFoundException e) {
		throw new ResourceNotFoundException(id);
	}
	} 

	private void updateData(Usuario entidade, Usuario obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setCelular(obj.getCelular());
		
	}
}
