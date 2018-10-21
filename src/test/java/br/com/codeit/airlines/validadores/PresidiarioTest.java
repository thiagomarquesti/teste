package br.com.codeit.airlines.validadores;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import br.com.codeit.airlines.exceptions.PresidiarioComTripulacaoSemPolicialException;
import br.com.codeit.airlines.tripulantes.TipoTripulante;
import br.com.codeit.airlines.tripulantes.Tripulante;

public class PresidiarioTest {

	@Test(expected = PresidiarioComTripulacaoSemPolicialException.class)
	public void naoDevePermitirPresidiarioComATripulacaoSemPolicial() throws Exception {
		Set<Tripulante> tripulantes = new HashSet<Tripulante>();
		tripulantes.add(new Tripulante(TipoTripulante.PRESIDIARIO));
		tripulantes.add(new Tripulante(TipoTripulante.COMISSARIA1));
		TipoTripulante.PRESIDIARIO.validar(tripulantes);
	}

	@Test
	public void devePermitirOPresidiarioSozinho() {
		Set<Tripulante> tripulantes = new HashSet<Tripulante>();
		tripulantes.add(new Tripulante(TipoTripulante.PRESIDIARIO));
		TipoTripulante.PRESIDIARIO.validar(tripulantes);
	}

	@Test
	public void devePermitirPresidiarioComATripulacaoComPolicial() throws Exception {
		Set<Tripulante> tripulantes = new HashSet<Tripulante>();
		tripulantes.add(new Tripulante(TipoTripulante.PRESIDIARIO));
		tripulantes.add(new Tripulante(TipoTripulante.COMISSARIA1));
		tripulantes.add(new Tripulante(TipoTripulante.POLICIAL));
		TipoTripulante.PRESIDIARIO.validar(tripulantes);
	}

}
