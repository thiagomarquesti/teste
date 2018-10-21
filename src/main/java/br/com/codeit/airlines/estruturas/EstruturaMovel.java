package br.com.codeit.airlines.estruturas;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.codeit.airlines.exceptions.RegraDirecaoVeiculoException;
import br.com.codeit.airlines.tripulantes.TipoTripulante;
import br.com.codeit.airlines.tripulantes.Tripulante;

public abstract class EstruturaMovel extends Estrutura {

	private Set<Tripulante> ocupantes = new HashSet<Tripulante>();

	private EstruturaFisica localEstacionamento;

	public EstruturaMovel(EstruturaFisica localEstacionamento) {
		this.localEstacionamento = localEstacionamento;
	}

	protected abstract List<TipoTripulante> getTipoTripulantesHabilitadosADirigir();

	public EstruturaFisica getLocalEstacionamento() {
		return localEstacionamento;
	}

	public Set<Tripulante> getTripulantesDoLocalEstacionamento() {
		return localEstacionamento.getTripulantes();
	}

	public void adicionarOcupanteDoLocalEstacionamento(TipoTripulante tipoTripulante) {
		validarQuantidadeOcupantes();
		Tripulante removido = localEstacionamento.removerTripulantePorTipo(tipoTripulante);
		if (removido != null) {
			ocupantes.add(removido);
		}
	}

	public void removerOcupanteParaOLocalEstacionamento(TipoTripulante tipoTripulante) {
		Tripulante tripulanteRemover = getTripulantePorTipo(tipoTripulante);
		ocupantes.remove(tripulanteRemover);
		localEstacionamento.adicionarTripulante(tripulanteRemover);
	}

	private Tripulante getTripulantePorTipo(TipoTripulante tipoTripulante) {
		Tripulante tripulante = ocupantes.stream().filter(f -> f.getTipo().equals(tipoTripulante)).findAny()
				.orElseThrow(() -> new IllegalArgumentException(String.format("Ocupante com %s não está no %s",
						tipoTripulante.getDescricao(), getDescricaoEstrutura())));
		return tripulante;
	}

	public Set<Tripulante> getOcupantes() {
		return Collections.unmodifiableSet(this.ocupantes);
	}

	public void locomoverEDescerOcupantes(EstruturaFisica destino) {
		validarSeLocalDestinoHeDiferenteDoLocalEstacionamento(destino);
		validarSeUmDosOcupantesPodeDirigir();
		validarRegrasTripulantesLocalOrigem();
		validarRegrasTripulantesLocalDestino(destino);

		ocupantes.stream().forEach(t -> destino.adicionarTripulante(t));
		ocupantes.clear();
		localEstacionamento = destino;
	}

	private void validarSeLocalDestinoHeDiferenteDoLocalEstacionamento(EstruturaFisica destino) {
		if (destino.equals(localEstacionamento)) {
			throw new IllegalArgumentException("Local de estacionamento deve ser diferente do destino");
		}
	}

	private void validarSeUmDosOcupantesPodeDirigir() {
		if (!ocupantes.stream().filter(f -> getTipoTripulantesHabilitadosADirigir().contains(f.getTipo())).findAny()
				.isPresent()) {
			throw new RegraDirecaoVeiculoException();
		}
	}

	private void validarRegrasTripulantesLocalOrigem() {
		localEstacionamento.getTripulantes().stream()
				.forEach(p -> p.getTipo().validar(localEstacionamento.getTripulantes()));
	}

	private void validarRegrasTripulantesLocalDestino(EstruturaFisica destino) {
		Set<Tripulante> tripulantesValidarDestino = new HashSet<>();
		tripulantesValidarDestino.addAll(destino.getTripulantes());
		tripulantesValidarDestino.addAll(ocupantes);
		tripulantesValidarDestino.stream().forEach(t -> t.getTipo().validar(tripulantesValidarDestino));
	}

	private void validarQuantidadeOcupantes() {
		if (ocupantes.size() == getQuantidadeMaximaTripulantes()) {
			throw new IllegalStateException(String.format("Não é permitido mais de %d tripulantes no %s",
					getQuantidadeMaximaTripulantes(), getDescricaoEstrutura()));
		}
	}

}
