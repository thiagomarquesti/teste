package br.com.thiago.airlines.validadores;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import br.com.thiago.exceptions.ComissariaSozinhaComPilotoException;
import br.com.thiago.tripulantes.TipoTripulante;
import br.com.thiago.tripulantes.Tripulante;

public class ComissariaValidadorTest {

	@Test(expected = ComissariaSozinhaComPilotoException.class)
	public void naoDevePermitirComissariaFiqueSozinhaComPiloto() throws Exception {
		Set<Tripulante> tripulantes = new HashSet<Tripulante>();
		tripulantes.add(new Tripulante(TipoTripulante.COMISSARIA1));
		tripulantes.add(new Tripulante(TipoTripulante.OFICIAL1));
		tripulantes.add(new Tripulante(TipoTripulante.PILOTO));
		TipoTripulante.COMISSARIA1.validar(tripulantes);
	}

	@Test
	public void devePermitirQueOficialFiqueComChefeDeServicoComAPresensaDoPiloto() {
		Set<Tripulante> tripulantes = new HashSet<Tripulante>();
		tripulantes.add(new Tripulante(TipoTripulante.COMISSARIA1));
		tripulantes.add(new Tripulante(TipoTripulante.OFICIAL1));
		tripulantes.add(new Tripulante(TipoTripulante.CHEFE_DE_SERVICO));
		tripulantes.add(new Tripulante(TipoTripulante.PILOTO));
		TipoTripulante.COMISSARIA1.validar(tripulantes);
	}

}
