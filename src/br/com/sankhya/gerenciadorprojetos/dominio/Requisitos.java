/*
Nome do autor: Ilton Batista da Silva Júnior
Data de criação do arquivo: 20/02/2019
Objetivo sucinto da classe:Cria uma classe que manipula os requisitos e atualizações de prioridade de um produto
Escopo do projeto:  https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/

package br.com.sankhya.gerenciadorprojetos.dominio;

import java.io.Serializable;

public class Requisitos implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer requisitoID;
	private String descricao;
	
	public Requisitos() {
		super();
	}
	
	public Requisitos(Integer requisitoID, String descricao) {
		super();
		this.requisitoID = requisitoID;
		this.descricao = descricao;
	}
	
	public Integer getRequisitoID() {
		return requisitoID;
	}
	
	public void setRequisitoID(Integer requisitoID) {
		this.requisitoID = requisitoID;
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
		result = prime * result + ((requisitoID == null) ? 0 : requisitoID.hashCode());
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
		Requisitos other = (Requisitos) obj;
		if (requisitoID == null) {
			if (other.requisitoID != null)
				return false;
		} else if (!requisitoID.equals(other.requisitoID))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Requisitos ["
				+ "requisitoID=" + requisitoID + ", "
				+ "descricao=" + descricao + "]";
	}
	
}
