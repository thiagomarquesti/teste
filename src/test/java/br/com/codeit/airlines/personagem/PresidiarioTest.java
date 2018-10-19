package br.com.codeit.airlines.personagem;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import br.com.codeit.airlines.exceptions.PresidiarioComTripulacaoSemPolicialException;

public class PresidiarioTest {

	@Test(expected = PresidiarioComTripulacaoSemPolicialException.class)
	public void naoDevePermitirPresidiarioComATripulacaoSemPolicial() throws Exception {
		Set<Personagem> personagens = new HashSet<Personagem>();
		personagens.add(TipoPersonagem.PRESIDIARIO.getPersonagem());
		personagens.add(TipoPersonagem.COMISSARIA1.getPersonagem());
		TipoPersonagem.PRESIDIARIO.getPersonagem().validarPoliticasEmpresa(personagens);
	}

	@Test
	public void devePermitirOPresidiarioSozinho() {
		Set<Personagem> personagens = new HashSet<Personagem>();
		personagens.add(TipoPersonagem.PRESIDIARIO.getPersonagem());
		TipoPersonagem.PRESIDIARIO.getPersonagem().validarPoliticasEmpresa(personagens);
	}

	@Test
	public void devePermitirPresidiarioComATripulacaoComPolicial() throws Exception {
		Set<Personagem> personagens = new HashSet<Personagem>();
		personagens.add(TipoPersonagem.PRESIDIARIO.getPersonagem());
		personagens.add(TipoPersonagem.COMISSARIA1.getPersonagem());
		personagens.add(TipoPersonagem.POLICIAL.getPersonagem());
		TipoPersonagem.PRESIDIARIO.getPersonagem().validarPoliticasEmpresa(personagens);
	}

}
