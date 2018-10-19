package br.com.codeit.airlines.personagem;

import java.util.Set;

public abstract class Personagem {

	private String nome;

	public Personagem(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public abstract void validarPoliticasEmpresa(Set<Personagem> personagens);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Personagem other = (Personagem) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
