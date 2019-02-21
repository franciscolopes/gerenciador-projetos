package br.com.sankhya.gerenciadorprojetos.enums;
/*
Nome do autor: Ilton Batista da Silva Júnior
Data de criação do arquivo:20/02/2019
Objetivo sucinto do enum: gerenciar a prioridade de um requisito
Escopo do projeto:  https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/

public enum Prioridade {
	ALTA(1, "Alta"),
	MEDIA(2, "Media"),
	BAIXA(3, "Baixa");
	
	int codigo;
	String descricao;
	
	private Prioridade(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Prioridade toEnum(Integer codigo) {
		
		if(codigo == null) {
			return null;
		}
		
		for(Prioridade x : Prioridade.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Prioridade inválido: " + codigo);
	}
}
