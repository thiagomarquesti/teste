package br.com.codeit.airlines.exceptions;

public class ComissariaSozinhaComPilotoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Não é permitido que o Piloto fique sozinho com as comissárias";
	}

}
