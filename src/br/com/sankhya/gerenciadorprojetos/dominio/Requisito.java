/*
Nome do autor: Ilton Batista da Silva Júnior
Data de criação do arquivo: 20/02/2019
Objetivo sucinto da classe:Cria uma classe que manipula os requisitos e atualizações de prioridade de um produto
Escopo do projeto:  https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/

package br.com.sankhya.gerenciadorprojetos.dominio;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

import br.com.sankhya.gerenciadorprojetos.enums.Prioridade;

@SuppressWarnings("unused")
public class Requisito implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer requisitoID;
	private String descricao;
	private Integer prioridade;
	
	public Requisito() {
		super();
	}
	
	public Requisito(Integer requisitoID, String descricao, Prioridade prioridadeEnum) {
		super();
		this.requisitoID = requisitoID;
		this.descricao = descricao;
		this.prioridade = prioridadeEnum.getCodigo();
	}
	


	public Prioridade getPrioridade() {
		return Prioridade.toEnum(prioridade);
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
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
	
	public void atualizaPrioridade(Prioridade prioridade) {
		if(prioridade == Prioridade.toEnum(1)) {
			System.out.println("ALTA");
		}
		else if(prioridade == Prioridade.toEnum(2)) {
			System.out.println("MEDIA");
		}
		else if(prioridade == Prioridade.toEnum(3)) {
			System.out.println("BAIXA");

		}
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
		Requisito other = (Requisito) obj;
		if (requisitoID == null) {
			if (other.requisitoID != null)
				return false;
		} else if (!requisitoID.equals(other.requisitoID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Requisito ["
				+ "requisitoID=" + requisitoID + ", "
				+ "descricao=" + descricao + ", "
				+ "prioridade=" + getPrioridade()+ "]";
	}


	
	
	
}
