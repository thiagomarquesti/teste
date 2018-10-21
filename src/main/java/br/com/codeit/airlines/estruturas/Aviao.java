package br.com.codeit.airlines.estruturas;

public class Aviao extends EstruturaFisica {

	public Aviao() {
	}

	@Override
	protected String getDescricaoEstrutura() {
		return "avião";
	}

	@Override
	protected int getQuantidadeMaximaTripulantes() {
		return 8;
	}
	

}
