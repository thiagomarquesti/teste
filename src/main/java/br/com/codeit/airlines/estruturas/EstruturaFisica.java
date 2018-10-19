package br.com.codeit.airlines.estruturas;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import br.com.codeit.airlines.personagem.Personagem;

public abstract class EstruturaFisica extends Estrutura {

	private Set<Personagem> personagens = new HashSet<Personagem>();
	
	public void adicionarPersonagem(Personagem personagem) {
		if (personagem != null) {
			if (personagens.size() == quantidadePersonagensSuportada()) {
				throw new IllegalStateException(String.format("Não é permitido mais de %d personagens no %s",
						quantidadePersonagensSuportada(), getDescricaoEstrutura()));
			}
			personagens.add(personagem);
		}
	}

	public Personagem removerPersonagem(Personagem personagem) {
		if (personagem != null) {
			if (!personagens.contains(personagem)) {
				throw new IllegalStateException(String.format("personagem %s não se encontra no %s",
						personagem.getNome(), getDescricaoEstrutura()));
			}
			personagens.remove(personagem);
		}
		return personagem;
	}
	
	public Set<Personagem> removerTodosOsPassageiros() {
		Set<Personagem> personagensRemovidos = new HashSet<Personagem>();
		personagensRemovidos.addAll(personagens);
		personagens.clear();
		return personagensRemovidos;
	}

	public Set<Personagem> getPersonagens() {
		return Collections.unmodifiableSet(personagens);
	}
}
