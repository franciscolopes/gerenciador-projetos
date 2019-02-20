package br.com.sankhya.gerenciadorprojetos.enumsrequisitos;

public enum Prioridade {
	ALTA("Alta"),
	MEDIA("Media"),
	BAIXA("Baixa");
	
	String prioridade;

	private Prioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getPrioridade() {
		return prioridade;
	}
	
}
