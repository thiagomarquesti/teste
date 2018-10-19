package br.com.codeit.airlines;

import java.util.Set;

import br.com.codeit.airlines.estruturas.Aviao;
import br.com.codeit.airlines.estruturas.Carro;
import br.com.codeit.airlines.estruturas.Terminal;
import br.com.codeit.airlines.personagem.Personagem;

public class CompanhiaAerea {

	private Terminal terminal;
	private Aviao aviao;
	private Carro carro;
	
	public CompanhiaAerea() {
		iniciar();
	}
	
	public void reiniciar() {
		iniciar();
	}
	
	public Set<Personagem> getPersonagensTerminal() {
		return terminal.getPersonagens();
	}
	
	public Set<Personagem> getPersonagensCarro() {
		return carro.getOcupantes();
	}

	public Set<Personagem> getPersonagensAviao() {
		return aviao.getPersonagens();
	}
	
	private void iniciar() {
		terminal = new Terminal();
		aviao = new Aviao();
		carro = new Carro(terminal);
	}
	
}
