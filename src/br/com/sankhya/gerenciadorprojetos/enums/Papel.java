/*
Nome do autor: João Victor Oliveira Marques
Data de criação do arquivo: 20/02/2019
Objetivo sucinto da classe: Desenvolver um enum para dar ID para diferentes funcionarios
Escopo do projeto: https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/

package br.com.sankhya.gerenciadorprojetos.enums;

public enum Papel {

	GERENTE(1, "Gerente"), COLABORADOR(2, "Colaborador");

	private int codigo;
	private String descricao;

	private Papel(int cod, String descricao) {
		this.codigo = cod;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Papel toEnum(Integer codigo) {

		if (codigo == null) {
			return null;
		}

		for (Papel x : Papel.values()) {
			if (codigo.equals(x.getCodigo())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}