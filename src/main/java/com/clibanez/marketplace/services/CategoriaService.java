package com.clibanez.marketplace.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clibanez.marketplace.domain.Categoria;
import com.clibanez.marketplace.repositories.CategoriaRepository;
import com.clibanez.marketplace.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> findById = categoriaRepository.findById(id);
		return findById.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public Categoria saveAll(Categoria categoria) {
		categoria.setId(null);
		return categoriaRepository.save(categoria);
	}
	

}