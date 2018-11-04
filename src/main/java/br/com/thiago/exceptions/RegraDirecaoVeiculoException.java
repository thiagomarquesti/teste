package br.com.thiago.exceptions;

import br.com.thiago.tripulantes.TipoTripulante;

public class RegraDirecaoVeiculoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return String.format("Somente o %s, %s ou %s podem dirigir o veículo", TipoTripulante.PILOTO.getDescricao(),
				TipoTripulante.CHEFE_DE_SERVICO.getDescricao(), TipoTripulante.POLICIAL.getDescricao());
	}
}
