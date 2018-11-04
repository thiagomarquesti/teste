package br.com.thiago.estruturas;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import br.com.thiago.tripulantes.TipoTripulante;
import br.com.thiago.tripulantes.Tripulante;

public abstract class EstruturaFisica extends Estrutura {

	private Set<Tripulante> tripulantes = new HashSet<Tripulante>();
	
	public void adicionarTripulante(Tripulante tripulante) {
		if (tripulante != null) {
			if (tripulantes.size() == getQuantidadeMaximaTripulantes()) {
				throw new IllegalStateException(String.format("Não é permitido mais de %d tripulantes no %s",
						getQuantidadeMaximaTripulantes(), getDescricaoEstrutura()));
			}
			tripulantes.add(tripulante);
		}
	}
	
	public Tripulante removerTripulantePorTipo(TipoTripulante tipoTripulante) {
		Tripulante tripulante = tripulantes.stream().filter(f -> f.getTipo().equals(tipoTripulante)).findAny().orElse(null);
		return removerTripulante(tripulante);
	}

	public Tripulante removerTripulante(Tripulante tripulante) {
		if (tripulante != null) {
			if (!tripulantes.contains(tripulante)) {
				throw new IllegalStateException(String.format("Tripulante %s não se encontra no %s",
						tripulante.getTipo().getDescricao(), getDescricaoEstrutura()));
			}
			tripulantes.remove(tripulante);
		}
		return tripulante;
	}
	
	public Set<Tripulante> getTripulantes() {
		return Collections.unmodifiableSet(tripulantes);
	}
	
	@Override
	public String toString() {
		return getDescricaoEstrutura() + "[tripulantes: " + tripulantes + "]";
	}
}
