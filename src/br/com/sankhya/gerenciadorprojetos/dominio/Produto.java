/*
Nome do autor: Ilton Batista da Silva Júnior
Data de criação do arquivo: 27/02/2019
Objetivo sucinto da classe: Cria uma classe que manipula estado e comportamento de um produto e exibe seus requisitos.
Escopo do projeto: https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/

package br.com.sankhya.gerenciadorprojetos.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.sankhya.gerenciadorprojetos.enums.Prioridade;

public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer produtoID;
	private String nome;
	private String descricao;

	private List<Requisito> requisitos = new ArrayList<>();

	private Projeto projeto;

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

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
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

	public String exibirTodosRequisitos() {
		StringBuffer listaRequisitos = new StringBuffer("  NOME \t\t|\t REQUISITO ID \t|\t DESCRICAO \t\t\t|\t PRIORIDADE \t|\t\n");

		for (Requisito requisitoProduto : requisitos) {

			listaRequisitos.append("  ").append(getNome()).append(" \t|\t ")
			.append(requisitoProduto.getRequisitoID()).append(" \t\t|\t ")
			.append(requisitoProduto.getDescricao()).append(" \t|\t ")
			.append(requisitoProduto.getPrioridade()).append(" \t\t|\t \n");
		}
		return listaRequisitos.toString();
	}

	public String exibirRequisitosPorPrioridade(Prioridade prioridade) {
		StringBuffer listaRequisitos = new StringBuffer("  NOME \t\t|\t REQUISITO ID \t|\t DESCRICAO \t\t\t|\t PRIORIDADE \t|\t\n");

		for (Requisito requisitoProduto : requisitos) {
			if (requisitoProduto.getPrioridade().getCodigo() == prioridade.getCodigo()) {

				listaRequisitos.append("  ").append(getNome()).append(" \t|\t ")
				.append(requisitoProduto.getRequisitoID()).append(" \t\t|\t ")
				.append(requisitoProduto.getDescricao()).append(" \t|\t ")
				.append(requisitoProduto.getPrioridade()).append(" \t\t|\t\n");
			}
		}
		return listaRequisitos.toString();
	}

	@Override
	public String toString() {
		return "Produto [" + "ProjetoID=" + projeto.getProjetoID() + ", " + " ProjetoNome=" + projeto.getNome() + ", "
				+ " produtoID=" + produtoID + ", " + "nome=" + nome + ", " + "descricao=" + descricao + "]";
	}
}