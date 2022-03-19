package com.clibanez.marketplace;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.clibanez.marketplace.domain.Categoria;
import com.clibanez.marketplace.domain.Cidade;
import com.clibanez.marketplace.domain.Estado;
import com.clibanez.marketplace.domain.Produto;
import com.clibanez.marketplace.repositories.CategoriaRepository;
import com.clibanez.marketplace.repositories.CidadeRepository;
import com.clibanez.marketplace.repositories.EstadoRepository;
import com.clibanez.marketplace.repositories.ProdutoRepository;

@SpringBootApplication
public class MarketplaceApplication implements CommandLineRunner{
	

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;

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
		
		
		Estado est1 = new Estado(null, "Paraiba");
		Estado est2 = new Estado(null, "Pernanbuco");
		
		Cidade cid1 = new Cidade(null, "Campina Grande", est1);
		Cidade cid2 = new Cidade(null, "Joao Pessoa", est1);
		Cidade cid3 = new Cidade(null, "Recife", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1,cid2));
		est2.getCidades().addAll(Arrays.asList(cid3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));
		
		
		
	}

}
