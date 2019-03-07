/*
Nome do autor: Ezequiel de Oliveira Sant'Ana 
Data de criação do arquivo: 19/02/2019
Objetivo sucinto do enum: Cria enum para exibir status do projeto.
Escopo do projeto: https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/
package br.com.sankhya.gerenciadorprojetos.enums;

public enum EstadoProjeto {
	EM_ANDAMENTO(1, "Em_Andamento"), CONCLUIDO(2,"Concluido");

	private int codigo;
	private String descricao;
	

	EstadoProjeto(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoProjeto toEnum(Integer codigo) {
		if(codigo == null) {
			return null;
		}
		for(EstadoProjeto i : EstadoProjeto.values()) {
			if(codigo.equals(i.getCodigo())) {
				return i;
			}
		}
		throw new IllegalArgumentException("ID invalido: " + codigo);
	}

}
