package br.com.codeit.airlines.personagem;

import java.util.Set;

import br.com.codeit.airlines.exceptions.PresidiarioComTripulacaoSemPolicialException;

public class Presidiario extends Personagem {

	public Presidiario(String nome) {
		super(nome);
	}

	@Override
	public void validarPoliticasEmpresa(Set<Personagem> personagens) {
		if (personagens.size() > 1 && !personagens.contains(TipoPersonagem.POLICIAL.getPersonagem())) {
			throw new PresidiarioComTripulacaoSemPolicialException();
		}
	}

}
