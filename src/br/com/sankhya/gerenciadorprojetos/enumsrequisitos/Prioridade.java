/*
Nome do autor: Ilton Batista da Silva Júnior
Data de criação do arquivo:20/02/2019
Objetivo sucinto do enum: gerenciar a prioridade de um requisito
Escopo do projeto:  https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/

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
