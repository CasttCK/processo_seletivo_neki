package br.com.neki.projetoSelecao.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus
public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NotFoundException(String exception) {
		super(exception);
		
	}
}


