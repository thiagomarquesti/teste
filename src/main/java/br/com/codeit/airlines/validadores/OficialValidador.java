package br.com.codeit.airlines.validadores;

import java.util.Set;

import br.com.codeit.airlines.exceptions.OficialSozinhoComChefeDeServicoException;
import br.com.codeit.airlines.tripulantes.TipoTripulante;
import br.com.codeit.airlines.tripulantes.Tripulante;

public class OficialValidador implements ValidadorTripulante {

	@Override
	public void validar(Set<Tripulante> tripulantes) {
		boolean chefeDeServicoPresente = tripulantes.stream()
				.filter(f -> f.getTipo().equals(TipoTripulante.CHEFE_DE_SERVICO)).findAny().isPresent();
		boolean pilotoPresente = tripulantes.stream().filter(f -> f.getTipo().equals(TipoTripulante.PILOTO))
				.findAny().isPresent();
		if (chefeDeServicoPresente && !pilotoPresente) {
			throw new OficialSozinhoComChefeDeServicoException();
		}
	}

}
