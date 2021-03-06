package com.clibanez.marketplace;



import java.text.SimpleDateFormat;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.clibanez.marketplace.domain.Categoria;
import com.clibanez.marketplace.domain.Cidade;
import com.clibanez.marketplace.domain.Cliente;
import com.clibanez.marketplace.domain.Endereco;
import com.clibanez.marketplace.domain.Estado;
import com.clibanez.marketplace.domain.ItemPedido;
import com.clibanez.marketplace.domain.Pagamento;

import com.clibanez.marketplace.domain.PagamentoComCartao;
import com.clibanez.marketplace.domain.Pedido;
import com.clibanez.marketplace.domain.Produto;
import com.clibanez.marketplace.domain.enums.EstadoPagamento;
import com.clibanez.marketplace.domain.enums.TipoCliente;
import com.clibanez.marketplace.repositories.CategoriaRepository;
import com.clibanez.marketplace.repositories.CidadeRepository;
import com.clibanez.marketplace.repositories.ClienteRepository;
import com.clibanez.marketplace.repositories.EnderecoRepository;
import com.clibanez.marketplace.repositories.EstadoRepository;
import com.clibanez.marketplace.repositories.ItemPedidoRepository;
import com.clibanez.marketplace.repositories.PagamentoRepository;
import com.clibanez.marketplace.repositories.PedidoRepository;
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
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(MarketplaceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informarica");
		Categoria cat2 = new Categoria(null,"casa");
		Categoria cat3 = new Categoria(null, "Cama mesa & banho");
		Categoria cat4 = new Categoria(null, "Brinquedos");
		Categoria cat5 = new Categoria(null, "Eletronico");
		Categoria cat6 = new Categoria(null, "Jardim");
		Categoria cat7 = new Categoria(null, "Automovel");
		
		Produto pro1 = new Produto(null, "mouse",35.00);
		Produto pro2 = new Produto(null, "Messa" ,10.00);
		Produto pro3 = new Produto(null, "Computador",4500.00);
		
		cat1.getProdutos().addAll(Arrays.asList(pro1,pro3));
		cat2.getProdutos().addAll(Arrays.asList(pro2));
		
//		List<Aula> aulas = c1.getAulas();
//		aulas.add(a1);
//		System.out.println(aulas);
		
		pro1.getCategorias().addAll(Arrays.asList(cat1));
		pro2.getCategorias().addAll(Arrays.asList(cat2));
		pro3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6,cat7));
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
		
		Cliente cli1 = new Cliente(null, "Clibanez", "clibanezzcaldas@gmail.com", "222.222.222.22", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("(83)98388-8903"));
		
		Endereco end1 = new Endereco(null, "Rua campos", "286b", null, "Portal", "58424-273", cli1, cid3);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, end1);
		
		
		Pagamento pagtoCartao1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagtoCartao1);
		
//		Pagamento pagtoBoleto = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped1, sdf.parse("20/10/2017 00:00"), null);
//		ped1.setPagamento(pagtoBoleto);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1));
		
		
		pedidoRepository.saveAll(Arrays.asList(ped1));
		pagamentoRepository.saveAll(Arrays.asList(pagtoCartao1));
		
	ItemPedido ip1 = new ItemPedido(ped1, pro3, 0.00, 1, 2000.00);
	
	ped1.getItens().addAll(Arrays.asList(ip1));
	
	ped1.getItens().addAll(Arrays.asList(ip1));
	
   pro1.getItens().addAll(Arrays.asList(ip1));
   
   itemPedidoRepository.saveAll(Arrays.asList(ip1));
		
		
		
		
	}

}
