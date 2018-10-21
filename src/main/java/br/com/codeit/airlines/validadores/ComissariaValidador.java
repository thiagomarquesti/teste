package br.com.codeit.airlines.validadores;

import java.util.Set;

import br.com.codeit.airlines.exceptions.ComissariaSozinhaComPilotoException;
import br.com.codeit.airlines.tripulantes.TipoTripulante;
import br.com.codeit.airlines.tripulantes.Tripulante;

public class ComissariaValidador implements ValidadorTripulante {

	@Override
	public void validar(Set<Tripulante> tripulantes) {
		boolean pilotoPresente = tripulantes.stream().filter(f -> f.getTipo().equals(TipoTripulante.PILOTO)).findAny()
				.isPresent();
		boolean chefeDeServicoPresente = tripulantes.stream()
				.filter(f -> f.getTipo().equals(TipoTripulante.CHEFE_DE_SERVICO)).findAny().isPresent();
		if (pilotoPresente && !chefeDeServicoPresente) {
			throw new ComissariaSozinhaComPilotoException();
		}
	}

}
