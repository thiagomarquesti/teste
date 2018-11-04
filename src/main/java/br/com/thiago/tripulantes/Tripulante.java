package br.com.thiago.tripulantes;

public class Tripulante {

	private TipoTripulante tipo;

	public Tripulante(TipoTripulante tipo) {
		super();
		this.tipo = tipo;
	}

	public TipoTripulante getTipo() {
		return tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tripulante other = (Tripulante) obj;
		if (tipo != other.tipo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return tipo.getDescricao();
	}

}
