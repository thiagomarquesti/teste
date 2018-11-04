package br.com.thiago.estruturas;

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
