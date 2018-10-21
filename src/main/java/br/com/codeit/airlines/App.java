package br.com.codeit.airlines;

import br.com.codeit.airlines.estruturas.Aviao;
import br.com.codeit.airlines.estruturas.Carro;
import br.com.codeit.airlines.estruturas.Terminal;
import br.com.codeit.airlines.tripulantes.TipoTripulante;

public class App {

	private static Terminal terminal = new Terminal();
	private static Aviao aviao = new Aviao();
	private static Carro carro = new Carro(terminal);

	/*
	 * Coloquei aqui o exemplo do fluxo correto da locomoção dos tripulantes para o
	 * avião, nos testes existem exemplos de fluxos falhos de acordo com as regras
	 * pré determinadas
	 */
	public static void main(String[] args) {

		System.out.println("----------INICIO---------");
		System.out.println(terminal.getTripulantes());

		ida(TipoTripulante.POLICIAL, TipoTripulante.PRESIDIARIO);

		volta(TipoTripulante.POLICIAL);

		ida(TipoTripulante.POLICIAL, TipoTripulante.OFICIAL1);

		volta(TipoTripulante.POLICIAL, TipoTripulante.PRESIDIARIO);

		ida(TipoTripulante.PILOTO, TipoTripulante.OFICIAL2);

		volta(TipoTripulante.PILOTO);

		ida(TipoTripulante.PILOTO, TipoTripulante.CHEFE_DE_SERVICO);

		volta(TipoTripulante.CHEFE_DE_SERVICO);

		ida(TipoTripulante.POLICIAL, TipoTripulante.PRESIDIARIO);

		volta(TipoTripulante.PILOTO);

		ida(TipoTripulante.PILOTO, TipoTripulante.CHEFE_DE_SERVICO);

		volta(TipoTripulante.CHEFE_DE_SERVICO);

		ida(TipoTripulante.CHEFE_DE_SERVICO, TipoTripulante.COMISSARIA1);

		volta(TipoTripulante.POLICIAL, TipoTripulante.PRESIDIARIO);

		ida(TipoTripulante.POLICIAL, TipoTripulante.COMISSARIA2);

		volta(TipoTripulante.POLICIAL);

		ida(TipoTripulante.POLICIAL, TipoTripulante.PRESIDIARIO);

		System.out.println("-----------FIM-----------");
	}

	private static void ida(TipoTripulante primeiroOcupante, TipoTripulante segundoOcupante) {
		carro.adicionarOcupanteDoLocalEstacionamento(primeiroOcupante);
		if (segundoOcupante != null) {
			carro.adicionarOcupanteDoLocalEstacionamento(segundoOcupante);
		}
		carro.locomoverEDescerOcupantes(aviao);
		System.out.println(terminal);
	}

	private static void volta(TipoTripulante primeiroOcupante, TipoTripulante segundoOcupante) {
		carro.adicionarOcupanteDoLocalEstacionamento(primeiroOcupante);
		if (segundoOcupante != null) {
			carro.adicionarOcupanteDoLocalEstacionamento(segundoOcupante);
		}
		carro.locomoverEDescerOcupantes(terminal);
		System.out.println(terminal);
	}

	private static void volta(TipoTripulante ocupante) {
		volta(ocupante, null);
	}
}
