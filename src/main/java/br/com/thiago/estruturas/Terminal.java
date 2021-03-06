package br.com.thiago.estruturas;

import br.com.thiago.tripulantes.TipoTripulante;
import br.com.thiago.tripulantes.Tripulante;

public class Terminal extends EstruturaFisica {

	public Terminal() {
		adicionarTripulante(new Tripulante(TipoTripulante.PILOTO));
		adicionarTripulante(new Tripulante(TipoTripulante.OFICIAL1));
		adicionarTripulante(new Tripulante(TipoTripulante.OFICIAL2));
		adicionarTripulante(new Tripulante(TipoTripulante.CHEFE_DE_SERVICO));
		adicionarTripulante(new Tripulante(TipoTripulante.COMISSARIA1));
		adicionarTripulante(new Tripulante(TipoTripulante.COMISSARIA2));
		adicionarTripulante(new Tripulante(TipoTripulante.POLICIAL));
		adicionarTripulante(new Tripulante(TipoTripulante.PRESIDIARIO));
	}

	@Override
	protected String getDescricaoEstrutura() {
		return "terminal";
	}

	@Override
	protected int getQuantidadeMaximaTripulantes() {
		return 8;
	}
}
