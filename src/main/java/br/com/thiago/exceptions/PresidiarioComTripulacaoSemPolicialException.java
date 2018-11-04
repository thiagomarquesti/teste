package br.com.thiago.exceptions;

public class PresidiarioComTripulacaoSemPolicialException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "O Presidiário não pode ficar com a tripulação sem o policial";
	}

}
