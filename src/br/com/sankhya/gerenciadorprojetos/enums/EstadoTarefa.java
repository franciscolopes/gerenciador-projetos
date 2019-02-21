/*
Nome do autor: Fábio Augusto Amaro Jaime
Data de criação do arquivo: 20/02/2019
Objetivo sucinto do enum: Manipular os estados da tarefa para pendente, concluida e atrasada.
Escopo do projeto: https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/

package br.com.sankhya.gerenciadorprojetos.enums;

public enum EstadoTarefa {
	PENDENTE(1, "Pendente"), CONCLUIDA(2, "Concluida"), ATRASADA(3, "Atrasada");
	
	private int codigo;
	private String descricao;
	
	private EstadoTarefa(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EstadoTarefa toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		
		for (EstadoTarefa x : EstadoTarefa.values()) {
			if (codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
