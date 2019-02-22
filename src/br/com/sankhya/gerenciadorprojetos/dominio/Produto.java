/*
Nome do autor: Ilton Batista da Silva J�nior
Data de cria��o do arquivo: Ilton Batista da Silva J�nior
Objetivo sucinto da classe: Cria uma classe que manipula estado e comportamento de um produto e exibe seus requisitos
Escopo do projeto:  https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/

package br.com.sankhya.gerenciadorprojetos.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.sankhya.gerenciadorprojetos.enums.Prioridade;

public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer produtoID;
	private String nome;
	private String descricao;
	private List<Requisito> requisitos = new ArrayList<>();
	
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
	
	public List<Requisito> getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(List<Requisito> requisitos) {
		this.requisitos = requisitos;
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
	
	public List<Requisito> exibirTodosRequisitos(){

		return requisitos;
		
	}
	
	public List<Requisito> exibirRequisitosPorPrioridade(Prioridade prioridade){		
		
		return null;
		
	}
	
	@Override
	public String toString() {
		return "\n__________________________________\n"
				+ "\nprodutoID = " + getProdutoID()
				+ "\nnome = " + getNome()
				+ "\ndescricao = " + getDescricao();
	}
	
}
