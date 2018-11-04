package br.com.thiago.validadores;

import java.util.Set;

import br.com.thiago.exceptions.OficialSozinhoComChefeDeServicoException;
import br.com.thiago.tripulantes.TipoTripulante;
import br.com.thiago.tripulantes.Tripulante;

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
