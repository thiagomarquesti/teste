package br.com.codeit.airlines.personagem;

import java.util.Set;

import br.com.codeit.airlines.exceptions.OficialSozinhoComChefeDeServicoException;

public class Oficial extends Personagem {

	public Oficial(String nome) {
		super(nome);
	}

	@Override
	public void validarPoliticasEmpresa(Set<Personagem> personagens) {
		boolean chefeDeServicoPresente = personagens.stream()
				.filter(p -> p.equals(TipoPersonagem.CHEFE_DE_SERVICO.getPersonagem())).findAny().isPresent();
		boolean pilotoPresente = personagens.stream().filter(p -> p.equals(TipoPersonagem.PILOTO.getPersonagem())).findAny().isPresent();
		if (chefeDeServicoPresente && !pilotoPresente) {
			throw new OficialSozinhoComChefeDeServicoException();
		}
	}

}
