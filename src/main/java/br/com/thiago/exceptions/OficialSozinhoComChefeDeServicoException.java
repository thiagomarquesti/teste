package br.com.thiago.exceptions;

public class OficialSozinhoComChefeDeServicoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Não é permitido que o Chefe de Serviço fique sozinho com os oficiais";
	}

}
