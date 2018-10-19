package br.com.codeit.airlines.personagem;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import br.com.codeit.airlines.exceptions.OficialSozinhoComChefeDeServicoException;

public class OficialTest {

	@Test(expected = OficialSozinhoComChefeDeServicoException.class)
	public void naoDevePermitirOficialFiqueSozinhoComChefeDeServico() throws Exception {
		Set<Personagem> personagens = new HashSet<Personagem>();
		personagens.add(TipoPersonagem.OFICIAL1.getPersonagem());
		personagens.add(TipoPersonagem.COMISSARIA1.getPersonagem());
		personagens.add(TipoPersonagem.CHEFE_DE_SERVICO.getPersonagem());
		TipoPersonagem.OFICIAL1.getPersonagem().validarPoliticasEmpresa(personagens);
	}

	@Test
	public void devePermitirQueOficialFiqueComChefeDeServicoComAPresensaDoPiloto() {
		Set<Personagem> personagens = new HashSet<Personagem>();
		personagens.add(TipoPersonagem.PILOTO.getPersonagem());
		personagens.add(TipoPersonagem.OFICIAL1.getPersonagem());
		personagens.add(TipoPersonagem.COMISSARIA1.getPersonagem());
		personagens.add(TipoPersonagem.CHEFE_DE_SERVICO.getPersonagem());
		TipoPersonagem.OFICIAL1.getPersonagem().validarPoliticasEmpresa(personagens);
	}

}
