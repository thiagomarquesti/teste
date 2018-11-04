package br.com.thiago.validadores;

import java.util.Set;

import br.com.thiago.exceptions.ComissariaSozinhaComPilotoException;
import br.com.thiago.tripulantes.TipoTripulante;
import br.com.thiago.tripulantes.Tripulante;

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
