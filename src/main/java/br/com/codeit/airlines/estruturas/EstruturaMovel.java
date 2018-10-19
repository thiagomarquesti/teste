package br.com.codeit.airlines.estruturas;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.codeit.airlines.personagem.Personagem;

public abstract class EstruturaMovel extends Estrutura {

	private Set<Personagem> ocupantes = new HashSet<Personagem>();

	private EstruturaFisica localEstacionamento;

	public EstruturaMovel(EstruturaFisica localEstacionamento) {
		this.localEstacionamento = localEstacionamento;
	}

	protected abstract List<Personagem> getPersonagensHabilitadosADirigir();

	public void adicionarOcupante(EstruturaFisica origem, Personagem personagem) {
		if (personagem != null) {
			validarQuantidadeOcupantes();
			validarSeLocalDeEstacionamentoHeIgual(origem);
			Personagem removido = origem.removerPersonagem(personagem);
			ocupantes.add(removido);
		}
	}

	public Set<Personagem> getOcupantes() {
		return Collections.unmodifiableSet(this.ocupantes);
	}

	public void removerOcupante(Personagem personagem, EstruturaFisica destino) {
		if (personagem != null) {
			ocupantes.remove(personagem);
			destino.adicionarPersonagem(personagem);
		}
	}

	public void locomoverEDescerTodos(EstruturaFisica destino) {
		if (!destino.equals(localEstacionamento)) {
			validarSeUmDosOcupantesPodeDirigir();
			validarRegrasPersonagensLocalOrigem();
			validarRegrasPersonagensLocalDestino(destino);
		}
		ocupantes.stream().forEach(p -> destino.adicionarPersonagem(p));
		ocupantes.clear();
	}

	private void validarSeUmDosOcupantesPodeDirigir() {
		if (!ocupantes.stream().filter(p -> getPersonagensHabilitadosADirigir().contains(p)).findAny().isPresent()) {
			throw new IllegalStateException("Não é permitida a direção do veículo pelos ocupantes atuais");
		}
	}

	private void validarRegrasPersonagensLocalOrigem() {
		localEstacionamento.getPersonagens().stream()
				.forEach(p -> p.validarPoliticasEmpresa(localEstacionamento.getPersonagens()));
	}

	private void validarRegrasPersonagensLocalDestino(EstruturaFisica destino) {
		Set<Personagem> personagensValidarDestino = new HashSet<>();
		personagensValidarDestino.addAll(destino.getPersonagens());
		personagensValidarDestino.addAll(ocupantes);
		personagensValidarDestino.stream().forEach(p -> p.validarPoliticasEmpresa(personagensValidarDestino));
	}

	private void validarSeLocalDeEstacionamentoHeIgual(EstruturaFisica local) {
		if (!localEstacionamento.equals(local)) {
			throw new IllegalStateException(
					"O Local informado para o embarque do ocupante não corresponde ao local de estacionamento.");
		}
	}

	private void validarQuantidadeOcupantes() {
		if (ocupantes.size() == quantidadePersonagensSuportada()) {
			throw new IllegalStateException(String.format("Não é permitido mais de %d personagens no %s",
					quantidadePersonagensSuportada(), getDescricaoEstrutura()));
		}
	}

}
