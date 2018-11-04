package br.com.thiago.estruturas;

import java.util.Arrays;
import java.util.List;

import br.com.thiago.tripulantes.TipoTripulante;

public class Carro extends EstruturaMovel {

	public Carro(EstruturaFisica localEstacionamento) {
		super(localEstacionamento);
	}

	@Override
	protected String getDescricaoEstrutura() {
		return "carro";
	}

	@Override
	protected int getQuantidadeMaximaTripulantes() {
		return 2;
	}

	@Override
	protected List<TipoTripulante> getTipoTripulantesHabilitadosADirigir() {
		return Arrays.asList(TipoTripulante.PILOTO, TipoTripulante.CHEFE_DE_SERVICO, TipoTripulante.POLICIAL);
	}

}
