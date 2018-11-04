package br.com.thiago.airlines.validadores;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import br.com.thiago.exceptions.PresidiarioComTripulacaoSemPolicialException;
import br.com.thiago.tripulantes.TipoTripulante;
import br.com.thiago.tripulantes.Tripulante;

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
