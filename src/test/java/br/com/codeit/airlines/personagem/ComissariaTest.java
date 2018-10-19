package br.com.codeit.airlines.personagem;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import br.com.codeit.airlines.exceptions.ComissariaSozinhaComPilotoException;
import br.com.codeit.airlines.exceptions.OficialSozinhoComChefeDeServicoException;

public class ComissariaTest {

	@Test(expected = ComissariaSozinhaComPilotoException.class)
	public void naoDevePermitirComissariaFiqueSozinhaComPiloto() throws Exception {
		Set<Personagem> personagens = new HashSet<Personagem>();
		personagens.add(TipoPersonagem.COMISSARIA1.getPersonagem());
		personagens.add(TipoPersonagem.OFICIAL1.getPersonagem());
		personagens.add(TipoPersonagem.PILOTO.getPersonagem());
		TipoPersonagem.COMISSARIA1.getPersonagem().validarPoliticasEmpresa(personagens);
	}

	@Test
	public void devePermitirQueOficialFiqueComChefeDeServicoComAPresensaDoPiloto() {
		Set<Personagem> personagens = new HashSet<Personagem>();
		personagens.add(TipoPersonagem.COMISSARIA1.getPersonagem());
		personagens.add(TipoPersonagem.OFICIAL1.getPersonagem());
		personagens.add(TipoPersonagem.CHEFE_DE_SERVICO.getPersonagem());
		personagens.add(TipoPersonagem.PILOTO.getPersonagem());
		TipoPersonagem.COMISSARIA1.getPersonagem().validarPoliticasEmpresa(personagens);
	}

}
