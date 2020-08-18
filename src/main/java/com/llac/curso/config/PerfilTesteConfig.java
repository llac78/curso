package com.llac.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.llac.curso.entidades.Pedido;
import com.llac.curso.entidades.Usuario;
import com.llac.curso.enums.PedidoStatus;
import com.llac.curso.repositorios.PedidoRepositorio;
import com.llac.curso.repositorios.UsuarioRepositorio;

@Configuration
@Profile("test") // deve ser o mesmo nome contido no arquivo application.properties
public class PerfilTesteConfig implements CommandLineRunner {

	// injeção de dependência
	@Autowired
	public UsuarioRepositorio usuarioRepositorio;

	@Autowired
	public PedidoRepositorio pedidoRepositorio;

	// será executado quando a aplicação iniciar
	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "998989898", "123");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "997777777", "123");
		
		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, u1);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u2);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u1);

		usuarioRepositorio.saveAll(Arrays.asList(u1, u2));
		pedidoRepositorio.saveAll(Arrays.asList(o1, o2, o3)); 	
	}
}
