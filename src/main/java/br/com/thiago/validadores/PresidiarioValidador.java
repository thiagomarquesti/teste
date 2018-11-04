package br.com.thiago.validadores;

import java.util.Set;

import br.com.thiago.exceptions.PresidiarioComTripulacaoSemPolicialException;
import br.com.thiago.tripulantes.TipoTripulante;
import br.com.thiago.tripulantes.Tripulante;

public class PresidiarioValidador implements ValidadorTripulante {

	@Override
	public void validar(Set<Tripulante> tripulantes) {
		if (tripulantes.size() > 1 && !tripulantes.stream().filter(f -> f.getTipo().equals(TipoTripulante.POLICIAL))
				.findAny().isPresent()) {
			throw new PresidiarioComTripulacaoSemPolicialException();
		}
	}

}
