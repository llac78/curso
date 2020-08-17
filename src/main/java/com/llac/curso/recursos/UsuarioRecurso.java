package com.llac.curso.recursos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.llac.curso.entidades.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecurso {

	@GetMapping
	public ResponseEntity<Usuario> listar(){
		Usuario u = new Usuario(1L, "MAria", "maria@gmail.com", "999999999", "12345");
		
		return ResponseEntity.ok().body(u);
	}
}
