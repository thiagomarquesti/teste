package br.com.thiago.tripulantes;

import java.util.Set;

import br.com.thiago.validadores.ComissariaValidador;
import br.com.thiago.validadores.OficialValidador;
import br.com.thiago.validadores.PresidiarioValidador;
import br.com.thiago.validadores.SemRegraValidacao;
import br.com.thiago.validadores.ValidadorTripulante;

public enum TipoTripulante {

	PILOTO("Piloto", new SemRegraValidacao()), OFICIAL1("Oficial 1", new OficialValidador()),
	OFICIAL2("Oficial 2", new OficialValidador()), CHEFE_DE_SERVICO("Chefe de Serviço", new SemRegraValidacao()),
	COMISSARIA1("Comissária 1", new ComissariaValidador()), COMISSARIA2("Comissária 2", new ComissariaValidador()),
	POLICIAL("Policial", new SemRegraValidacao()), PRESIDIARIO("Presidiário", new PresidiarioValidador());

	private String descricao;

	private ValidadorTripulante validador;

	private TipoTripulante(String descricao, ValidadorTripulante validador) {
		this.descricao = descricao;
		this.validador = validador;
	}

	public String getDescricao() {
		return descricao;
	}

	public void validar(Set<Tripulante> tripulantes) {
		this.validador.validar(tripulantes);
	}

}
