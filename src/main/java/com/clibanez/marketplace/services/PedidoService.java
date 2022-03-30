package com.clibanez.marketplace.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clibanez.marketplace.domain.Categoria;
import com.clibanez.marketplace.domain.Pedido;
import com.clibanez.marketplace.repositories.PedidoRepository;
import com.clibanez.marketplace.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido findById(Integer id) {
		Optional<Pedido> findById = pedidoRepository.findById(id);
		return findById.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

}
