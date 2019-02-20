/*
Nome do autor: Ezequiel de Oliveira Sant'Ana
Data de criacaoo do arquivo: 19/02/2019
Objetivo sucinto da classe: Cria classe Projeto que implementa metodos da interface ExibeTarefas
Escopo do projeto:  https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/

package br.com.sankhya.gerenciadorprojetos.dominio;

import java.io.Serializable;
import java.util.Date;

public class Projeto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer projetoID;
	private String nome;
	private String objetivoInteligente;
	private Date dataInicio;
	private Date dataFim;

	public Projeto() {

	}

	public Projeto(Integer projetoID, String nome, String objetivoInteligente, Date dataInicio, Date dataFim) {
		this.projetoID = projetoID;
		this.nome = nome;
		this.objetivoInteligente = objetivoInteligente;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public Integer getProjetoID() {
		return projetoID;
	}

	public void setProjetoID(Integer projetoID) {
		this.projetoID = projetoID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObjetivoInteligente() {
		return objetivoInteligente;
	}

	public void setObjetivoInteligente(String objetivoInteligente) {
		this.objetivoInteligente = objetivoInteligente;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((projetoID == null) ? 0 : projetoID.hashCode());
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
		Projeto other = (Projeto) obj;
		if (projetoID == null) {
			if (other.projetoID != null)
				return false;
		} else if (!projetoID.equals(other.projetoID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Projeto [projetoID=" + projetoID + ", nome=" + nome + ", objetivoInteligente=" + objetivoInteligente
				+ ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + "]";
	}

}