package com.clibanez.marketplace;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.clibanez.marketplace.domain.Categoria;
import com.clibanez.marketplace.domain.Produto;
import com.clibanez.marketplace.repositories.CategoriaRepository;
import com.clibanez.marketplace.repositories.ProdutoRepository;

@SpringBootApplication
public class MarketplaceApplication implements CommandLineRunner{
	

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(MarketplaceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informarica");
		Categoria cat2 = new Categoria(null,"casa");
		
		
		Produto pro1 = new Produto(null, "mouse",35.00);
		Produto pro2 = new Produto(null, "Messa" ,10.00);
		Produto pro3 = new Produto(null, "Computador",4500.00);
		
		cat1.getProdutos().addAll(Arrays.asList(pro1,pro3));
		cat2.getProdutos().addAll(Arrays.asList(pro2));
		
		pro1.getCategorias().addAll(Arrays.asList(cat1));
		pro2.getCategorias().addAll(Arrays.asList(cat2));
		pro3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(pro1,pro2,pro3));
		
		
		
	}

}
