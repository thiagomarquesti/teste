package br.com.thiago.airlines.estruturas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.thiago.estruturas.Aviao;
import br.com.thiago.estruturas.Carro;
import br.com.thiago.estruturas.Terminal;
import br.com.thiago.tripulantes.TipoTripulante;

public class CarroTest {

	@Test(expected = IllegalStateException.class)
	public void devePermitirSomenteDoisPassageirosNoCarro() throws Exception {
		Terminal terminal = new Terminal();
		Carro carro = new Carro(terminal);
		carro.adicionarOcupanteDoLocalEstacionamento(TipoTripulante.PILOTO);
		carro.adicionarOcupanteDoLocalEstacionamento(TipoTripulante.OFICIAL1);
		carro.adicionarOcupanteDoLocalEstacionamento(TipoTripulante.OFICIAL2);
	}

	@Test
	public void naoDevePermitirAMesmaPessoaNoCarroDuasVezes() {
		Terminal terminal = new Terminal();
		Carro carro = new Carro(terminal);
		carro.adicionarOcupanteDoLocalEstacionamento(TipoTripulante.PILOTO);
		carro.adicionarOcupanteDoLocalEstacionamento(TipoTripulante.PILOTO);
		carro.adicionarOcupanteDoLocalEstacionamento(TipoTripulante.PILOTO);
		assertEquals(1, carro.getOcupantes().size());
	}

	@Test
	public void deveLocomoverDoisPassageirosDoTerminalParaOAviao() {
		Terminal terminal = new Terminal();
		Aviao aviao = new Aviao();
		Carro carro = new Carro(terminal);
		
		carro.adicionarOcupanteDoLocalEstacionamento(TipoTripulante.POLICIAL);
		carro.adicionarOcupanteDoLocalEstacionamento(TipoTripulante.PRESIDIARIO);
		
		carro.locomoverEDescerOcupantes(aviao);
		
		assertEquals(2, aviao.getTripulantes().size());
	}
}
