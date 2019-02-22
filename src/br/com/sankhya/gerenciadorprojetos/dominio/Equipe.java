/*
Nome do autor: João Victor Oliveira Marques 
Data de criação do arquivo: 20/02/2019
Objetivo sucinto da classe: Criar metodos basicos para disponibilizar os relacionamentos
Escopo do projeto:  https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/

package br.com.sankhya.gerenciadorprojetos.dominio;

import java.io.Serializable;

public class Equipe implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer equipeID;
	private String nome;
	private Projeto projeto;

	public Equipe() {
	}

	public Equipe(Integer iD, String nome, Projeto projeto) {
		super();
		equipeID = iD;
		this.nome = nome;
		this.projeto = projeto;
	}

	public Integer getEquipeID() {
		return equipeID;
	}

	public void setEquipeID(Integer equipeID) {
		this.equipeID = equipeID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		result = prime * result + ((equipeID == null) ? 0 : equipeID.hashCode());
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
		Equipe other = (Equipe) obj;
		if (equipeID == null) {
			if (other.equipeID != null)
				return false;
		} else if (!equipeID.equals(other.equipeID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Equipe [equipeID=" + equipeID + ", nome=" + nome + ", projeto=" + projeto + "]";
	}
}