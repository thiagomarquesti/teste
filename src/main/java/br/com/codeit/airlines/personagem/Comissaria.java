package br.com.codeit.airlines.personagem;

import java.util.Set;

import br.com.codeit.airlines.exceptions.ComissariaSozinhaComPilotoException;

public class Comissaria extends Personagem {

	public Comissaria(String nome) {
		super(nome);
	}

	@Override
	public void validarPoliticasEmpresa(Set<Personagem> personagens) {
		boolean pilotoPresente = personagens.stream().filter(p -> p.equals(TipoPersonagem.PILOTO.getPersonagem())).findAny().isPresent();
		boolean chefeDeServicoPresente = personagens.stream()
				.filter(p -> p.equals(TipoPersonagem.CHEFE_DE_SERVICO.getPersonagem())).findAny().isPresent();
		if (pilotoPresente && !chefeDeServicoPresente) {
			throw new ComissariaSozinhaComPilotoException();
		}
	}
	
	

}
