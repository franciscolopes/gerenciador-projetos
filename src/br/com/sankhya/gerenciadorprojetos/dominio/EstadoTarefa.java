/*
Nome do autor: Fábio Augusto Amaro Jaime
Data de criação do arquivo: 20/02/2019
Objetivo sucinto do enum: Manipular os estados da tarefa para pendente, concluida e atrasada.
Escopo do projeto: https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/

package br.com.sankhya.gerenciadorprojetos.dominio;

public enum EstadoTarefa {
	PENDENTE(1), CONCLUIDA(2), ATRASADA(3);
	
	private int estado;
	
	EstadoTarefa(int estado) {
		this.estado = estado;
	}
	
	public int getEstado() {
		return estado;
	}
}
