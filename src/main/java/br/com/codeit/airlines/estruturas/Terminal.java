package br.com.codeit.airlines.estruturas;

import br.com.codeit.airlines.personagem.TipoPersonagem;

public class Terminal extends EstruturaFisica {
	
	public Terminal() {
		adicionarPersonagem(TipoPersonagem.PILOTO.getPersonagem());
		adicionarPersonagem(TipoPersonagem.OFICIAL1.getPersonagem());
		adicionarPersonagem(TipoPersonagem.OFICIAL2.getPersonagem());
		adicionarPersonagem(TipoPersonagem.CHEFE_DE_SERVICO.getPersonagem());
		adicionarPersonagem(TipoPersonagem.COMISSARIA1.getPersonagem());
		adicionarPersonagem(TipoPersonagem.COMISSARIA2.getPersonagem());
		adicionarPersonagem(TipoPersonagem.POLICIAL.getPersonagem());
		adicionarPersonagem(TipoPersonagem.PRESIDIARIO.getPersonagem());
	}

	@Override
	protected String getDescricaoEstrutura() {
		return "terminal";
	}

	@Override
	protected int quantidadePersonagensSuportada() {
		return 8;
	}
}
