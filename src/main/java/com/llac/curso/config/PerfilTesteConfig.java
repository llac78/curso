package com.llac.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.llac.curso.entidades.Usuario;
import com.llac.curso.repositorios.UsuarioRepositorio;

@Configuration
@Profile("test") // deve ser o mesmo nome contido no arquivo application.properties
public class PerfilTesteConfig implements CommandLineRunner {

	// injeção de dependência
	@Autowired
	public UsuarioRepositorio usuarioRepositorio;

	// será executado quando a aplicação iniciar
	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "998989898", "123");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "997777777", "123");
		
		usuarioRepositorio.saveAll(Arrays.asList(u1, u2));
	}
}
