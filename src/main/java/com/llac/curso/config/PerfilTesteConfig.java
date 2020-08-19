package com.llac.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.llac.curso.entidades.Categoria;
import com.llac.curso.entidades.ItemPedido;
import com.llac.curso.entidades.Pagamento;
import com.llac.curso.entidades.Pedido;
import com.llac.curso.entidades.Produto;
import com.llac.curso.entidades.Usuario;
import com.llac.curso.enums.PedidoStatus;
import com.llac.curso.repositorios.CategoriaRepositorio;
import com.llac.curso.repositorios.ItemPedidoRepositorio;
import com.llac.curso.repositorios.PedidoRepositorio;
import com.llac.curso.repositorios.ProdutoRepositorio;
import com.llac.curso.repositorios.UsuarioRepositorio;

@Configuration
@Profile("test") // deve ser o mesmo nome contido no arquivo applicion.properties
public class PerfilTesteConfig implements CommandLineRunner {

	// injeção de dependência
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	private ItemPedidoRepositorio itemPedidoRepositorio;


	// será executado quando a aplicação iniciar
	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "998989898", "123");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "997777777", "123");
		
		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, u1);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u2);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u1);
		
		Categoria c1 = new Categoria(null, "Eletrônicos");
		Categoria c2 = new Categoria(null, "Livros");
		Categoria c3 = new Categoria(null, "Computadores");
		
		Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		categoriaRepositorio.saveAll(Arrays.asList(c1, c2, c3));
		produtoRepositorio.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		p1.getCategorias().add(c2);
		p2.getCategorias().add(c1);
		p2.getCategorias().add(c3);
		p3.getCategorias().add(c3);
		p4.getCategorias().add(c3);
		p5.getCategorias().add(c2);

		produtoRepositorio.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		usuarioRepositorio.saveAll(Arrays.asList(u1, u2));
		pedidoRepositorio.saveAll(Arrays.asList(o1, o2, o3)); 
		
		ItemPedido ip1 = new ItemPedido(o1, p1, 2, p1.getPreco());
		ItemPedido ip2 = new ItemPedido(o1, p3, 1, p4.getPreco());
		ItemPedido ip3 = new ItemPedido(o2, p3, 2, p1.getPreco());
		ItemPedido ip4 = new ItemPedido(o3, p5, 2, p5.getPreco());
		
		itemPedidoRepositorio.saveAll(Arrays.asList(ip1, ip2, ip3, ip4));
		
		Pagamento pg1 = new Pagamento(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPagamento(pg1);
		pedidoRepositorio.save(o1); 

	}
}
