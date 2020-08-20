package com.llac.curso.recursos.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.llac.curso.services.exceptions.DatabaseException;
import com.llac.curso.services.exceptions.RecursoNaoEncontradoException;

@ControllerAdvice // vai interceptar as exceções que acontecerem para que o objeto possa executar um possível tratamento
public class RecursoExceptionHandler {

	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<ErroPadrao> recursoNaoEncontrado(RecursoNaoEncontradoException e, HttpServletRequest request){
		String erro = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao er = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
	
		return ResponseEntity.status(status).body(er);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<ErroPadrao> recursoNaoEncontrado(DatabaseException e, HttpServletRequest request){
		String erro = "Erro no Banco de Dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErroPadrao er = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
	
		return ResponseEntity.status(status).body(er);
	}

}
