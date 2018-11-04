package br.com.thiago.validadores;

import java.util.Set;

import br.com.thiago.tripulantes.Tripulante;

public interface ValidadorTripulante {

	public void validar(Set<Tripulante> tripulantes);
}
