package com.clibanez.marketplace.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clibanez.marketplace.domain.Categoria;
import com.clibanez.marketplace.repositories.CategoriaRepository;
import com.clibanez.marketplace.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository CategoriaRepository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> findById = CategoriaRepository.findById(id);
		return findById.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	

}