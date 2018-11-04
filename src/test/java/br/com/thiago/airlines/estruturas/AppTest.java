package br.com.thiago.airlines.estruturas;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.thiago.estruturas.Aviao;
import br.com.thiago.estruturas.Carro;
import br.com.thiago.estruturas.Terminal;
import br.com.thiago.exceptions.ComissariaSozinhaComPilotoException;
import br.com.thiago.exceptions.OficialSozinhoComChefeDeServicoException;
import br.com.thiago.exceptions.PresidiarioComTripulacaoSemPolicialException;
import br.com.thiago.exceptions.RegraDirecaoVeiculoException;
import br.com.thiago.tripulantes.TipoTripulante;

public class AppTest {

	private Terminal terminal;
	private Aviao aviao;
	private Carro carro;

	@Before
	public void setUp() {
		terminal = new Terminal();
		aviao = new Aviao();
		carro = new Carro(terminal);
	}
	
	@Test(expected = ComissariaSozinhaComPilotoException.class)
	public void naoDevePermitirComissariaSozinhaComPiloto() {
		ida(TipoTripulante.CHEFE_DE_SERVICO);
	}
	
	@Test(expected = OficialSozinhoComChefeDeServicoException.class)
	public void naoDevePermitirOficialSozinhoComChefeDeServico() {
		ida(TipoTripulante.PILOTO);
	}
	
	@Test(expected = PresidiarioComTripulacaoSemPolicialException.class) 
	public void naoDevePermitirQueOPresidiarioFiqueComOutrosTripulantesSemOPolicial(){
		ida(TipoTripulante.POLICIAL);
	}
	
	@Test
	public void devePermitirQueOPresidiarioFiqueSozinho() {
		ida(TipoTripulante.POLICIAL, TipoTripulante.PRESIDIARIO);
		volta(TipoTripulante.POLICIAL);
		assertEquals(1, aviao.getTripulantes().size());
		assertEquals(TipoTripulante.PRESIDIARIO, aviao.getTripulantes().stream().findFirst().get().getTipo());
	}
	
	@Test(expected = RegraDirecaoVeiculoException.class)
	public void naoDevePermitirQueOficialDirijaOCarro() {
		ida(TipoTripulante.OFICIAL1);
	}
	
	private void ida(TipoTripulante primeiroOcupante, TipoTripulante segundoOcupante) {
		carro.adicionarOcupanteDoLocalEstacionamento(primeiroOcupante);
		if (segundoOcupante != null) {
			carro.adicionarOcupanteDoLocalEstacionamento(segundoOcupante);
		}
		carro.locomoverEDescerOcupantes(aviao);
	}
	
	private void ida(TipoTripulante ocupante) {
		ida(ocupante, null);
	}

	private void volta(TipoTripulante primeiroOcupante, TipoTripulante segundoOcupante) {
		carro.adicionarOcupanteDoLocalEstacionamento(primeiroOcupante);
		if (segundoOcupante != null) {
			carro.adicionarOcupanteDoLocalEstacionamento(segundoOcupante);
		}
		carro.locomoverEDescerOcupantes(terminal);
	}

	private void volta(TipoTripulante ocupante) {
		volta(ocupante, null);
	}
}
