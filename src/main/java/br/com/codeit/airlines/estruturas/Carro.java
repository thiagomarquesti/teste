package br.com.codeit.airlines.estruturas;

import java.util.Arrays;
import java.util.List;

import br.com.codeit.airlines.personagem.Personagem;
import br.com.codeit.airlines.personagem.TipoPersonagem;

public class Carro extends EstruturaMovel {

	public Carro(EstruturaFisica localEstacionamento) {
		super(localEstacionamento);
	}

	@Override
	protected String getDescricaoEstrutura() {
		return "carro";
	}

	@Override
	protected int quantidadePersonagensSuportada() {
		return 2;
	}

	@Override
	protected List<Personagem> getPersonagensHabilitadosADirigir() {
		return Arrays.asList(TipoPersonagem.PILOTO.getPersonagem(), TipoPersonagem.CHEFE_DE_SERVICO.getPersonagem(),
				TipoPersonagem.POLICIAL.getPersonagem());
	}

}
