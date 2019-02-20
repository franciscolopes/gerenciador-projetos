/*
Nome do autor: Ezequiel de Oliveira Sant'Ana 
Data de criação do arquivo: 19/02/2019
Objetivo sucinto do enum: Cria enum para exibir status do projeto
Escopo do projeto:  https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/
package br.com.sankhya.gerenciadorprojetos.dominio;

public enum EstadoProjeto {
	EM_ANDAMENTO(1), CONCLUIDO(2);

	private int estado;

	EstadoProjeto(int estado) {
		this.estado = estado;
	}

	public int getEstadoProjeto() {
		return estado;
	}

}
