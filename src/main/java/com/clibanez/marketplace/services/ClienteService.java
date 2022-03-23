package com.clibanez.marketplace.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clibanez.marketplace.domain.Categoria;
import com.clibanez.marketplace.domain.Cliente;
import com.clibanez.marketplace.repositories.ClienteRepository;
import com.clibanez.marketplace.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> findById = clienteRepository.findById(id);
		return findById.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	

}
