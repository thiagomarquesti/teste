package br.com.codeit.airlines.estruturas;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import br.com.codeit.airlines.personagem.Personagem;
import br.com.codeit.airlines.personagem.TipoPersonagem;

public class CarroTest {

	@Test(expected = IllegalStateException.class)
	public void devePermitirSomenteDoisPassageirosNoCarro() throws Exception {
		Carro carro = new Carro();
		carro.adicionarPersonagem(TipoPersonagem.PILOTO.getPersonagem());
		carro.adicionarPersonagem(TipoPersonagem.OFICIAL1.getPersonagem());
		carro.adicionarPersonagem(TipoPersonagem.OFICIAL2.getPersonagem());
	}
	
	@Test
	public void naoDevePermitirAMesmaPessoaNoCarroDuasVezes() {
		Carro carro = new Carro();
		carro.adicionarPersonagem(TipoPersonagem.PILOTO.getPersonagem());
		carro.adicionarPersonagem(TipoPersonagem.PILOTO.getPersonagem());
		assertEquals(1, carro.getPersonagens().size());
	}
	
	@Test
	public void deveRemoverTodosPassageirosDoCarroRetornandoSuasReferencias() {
		Carro carro = new Carro();
		carro.adicionarPersonagem(TipoPersonagem.PILOTO.getPersonagem());
		carro.adicionarPersonagem(TipoPersonagem.OFICIAL1.getPersonagem());
		Set<Personagem> removidos = carro.removerTodosOsPassageiros();
		assertEquals(2, removidos.size());
	}
}
