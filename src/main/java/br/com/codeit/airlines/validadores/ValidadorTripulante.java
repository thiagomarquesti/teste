package br.com.codeit.airlines.validadores;

import java.util.Set;

import br.com.codeit.airlines.tripulantes.Tripulante;

public interface ValidadorTripulante {

	public void validar(Set<Tripulante> tripulantes);
}
