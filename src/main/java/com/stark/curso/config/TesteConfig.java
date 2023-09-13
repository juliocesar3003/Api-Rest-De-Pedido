package com.stark.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.stark.curso.entidades.Categoria;
import com.stark.curso.entidades.ItemPedido;
import com.stark.curso.entidades.Pagamento;
import com.stark.curso.entidades.Pedido;
import com.stark.curso.entidades.Produto;
import com.stark.curso.entidades.Usuario;
import com.stark.curso.entidades.enums.PedidoStatus;
import com.stark.curso.repositories.CategoriaRepository;
import com.stark.curso.repositories.ItemPedidoRepository;
import com.stark.curso.repositories.PedidoRepository;
import com.stark.curso.repositories.ProdutoRepository;
import com.stark.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PedidoRepository PedidoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 

		userRepository.saveAll(Arrays.asList(u1,u2));
		
		
		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"),PedidoStatus.Pago, u1);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"),PedidoStatus.Entrege, u2);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"),PedidoStatus.Cancelado, u1);
		
		PedidoRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategoria().add(cat2);
		p2.getCategoria().add(cat1);
		p2.getCategoria().add(cat3);
		p3.getCategoria().add(cat3);
		p4.getCategoria().add(cat3);
		p5.getCategoria().add(cat2);
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		ItemPedido oi1 = new ItemPedido(o1, p1, 2, p1.getPreço());
		ItemPedido oi2 = new ItemPedido(o1, p3, 1, p3.getPreço());
		ItemPedido oi3 = new ItemPedido(o2, p3, 2, p3.getPreço());
		ItemPedido oi4 = new ItemPedido(o3, p5, 2, p5.getPreço()); 
		
		itemPedidoRepository.saveAll(Arrays.asList(oi1, oi2,oi3,oi4));
		
		Pagamento pag1 = new Pagamento(null,Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPagamento(pag1);
		
		PedidoRepository.save(o1);
		
	}
	
	
	
}
