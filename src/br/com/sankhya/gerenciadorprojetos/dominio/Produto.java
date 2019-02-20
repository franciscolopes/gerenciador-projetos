/*
Nome do autor: Ilton Batista da Silva J�nior
Data de cria��o do arquivo: Ilton Batista da Silva J�nior
Objetivo sucinto da classe: Cria uma classe que manipula estado e comportamento de um produto e exibe seus requisitos
Escopo do projeto:  https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/

package br.com.sankhya.gerenciadorprojetos.dominio;

import java.io.Serializable;
import java.util.List;


@SuppressWarnings("unused")
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer produtoID;
	private String nome;
	private String descricao;

	public Produto() {
		super();
	}

	public Produto(Integer produtoID, String nome, String descricao) {
		super();
		this.produtoID = produtoID;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Integer getProdutoID() {
		return produtoID;
	}

	public void setProdutoID(Integer produtoID) {
		this.produtoID = produtoID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((produtoID == null) ? 0 : produtoID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (produtoID == null) {
			if (other.produtoID != null)
				return false;
		} else if (!produtoID.equals(other.produtoID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto ["
				+ "produtoID=" + produtoID + ", "
				+ "nome=" + nome + ", "
				+ "descricao=" + descricao + "]";
	}
	
}