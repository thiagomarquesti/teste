package br.com.codeit.airlines.personagem;

public enum TipoPersonagem {

	PILOTO(new Piloto("Piloto")), OFICIAL1(new Oficial("Oficial 1")), OFICIAL2(new Oficial("Oficial 2")),
	CHEFE_DE_SERVICO(new ChefeDeServico("Chefe de Serviço")), COMISSARIA1(new Comissaria("Comissária 1")),
	COMISSARIA2(new Comissaria("Comissária 2")), POLICIAL(new Policial("Policial")),
	PRESIDIARIO(new Presidiario("Presidiário"));

	private Personagem personagem;

	private TipoPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}

	public Personagem getPersonagem() {
		return personagem;
	}
}
