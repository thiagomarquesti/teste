package br.com.codeit.airlines.validadores;

import java.util.Set;

import br.com.codeit.airlines.exceptions.PresidiarioComTripulacaoSemPolicialException;
import br.com.codeit.airlines.tripulantes.TipoTripulante;
import br.com.codeit.airlines.tripulantes.Tripulante;

public class PresidiarioValidador implements ValidadorTripulante {

	@Override
	public void validar(Set<Tripulante> tripulantes) {
		if (tripulantes.size() > 1 && !tripulantes.stream().filter(f -> f.getTipo().equals(TipoTripulante.POLICIAL))
				.findAny().isPresent()) {
			throw new PresidiarioComTripulacaoSemPolicialException();
		}
	}

}
