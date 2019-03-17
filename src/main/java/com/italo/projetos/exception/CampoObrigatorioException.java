package com.italo.projetos.exception;

public class CampoObrigatorioException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CampoObrigatorioException(String message) {
		super(message);
	}
}
