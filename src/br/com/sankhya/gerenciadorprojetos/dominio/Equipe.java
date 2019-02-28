/*
Nome do autor: João Victor Oliveira Marques 
Data de criação do arquivo: 20/02/2019
Objetivo sucinto da classe: Criar metodos basicos para disponibilizar os relacionamentos
Escopo do projeto:  https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/

package br.com.sankhya.gerenciadorprojetos.dominio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.com.sankhya.gerenciadorprojetos.enums.Papel;

public class Equipe implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer equipeID;
	private String nome;
	private Projeto projeto;
	private Set<Atribuicao> atribuicoes = new HashSet<>();

	public Equipe() {
	}

	public Equipe(Integer iD, String nome) {
		super();
		equipeID = iD;
		this.nome = nome;
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

	public Set<Atribuicao> getAtribuicoes() {
		return atribuicoes;
	}

	public void setAtribuicoes(Set<Atribuicao> atribuicoes) {
		this.atribuicoes = atribuicoes;
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
		StringBuilder retorno = new StringBuilder();
		retorno.append("Equipe [equipeID= ");
		retorno.append(equipeID);
		retorno.append(", nome=");
		retorno.append(nome);
		retorno.append(", atribuicoes= ");
		for (Atribuicao atribuicao : atribuicoes) {
			retorno.append(" Nome do funcionario= ");
			retorno.append(atribuicao.getFuncionario().getNome());
			retorno.append(" Papel= ");
			retorno.append(atribuicao.getPapel());
		}
		return retorno.toString();
	}

	public String exibirFuncionaraios() {
		StringBuilder listaFuncionarios = new StringBuilder(
				"-----------------------------Lista de membros da equipe-----------------------------\n");

		for (Atribuicao atribuicao : atribuicoes) {
			listaFuncionarios.append(atribuicao.getFuncionario().getUsuarioID());
			listaFuncionarios.append(" - ");
			listaFuncionarios.append("Nome: ");
			listaFuncionarios.append(atribuicao.getFuncionario().getNome());
			listaFuncionarios.append(" Cargo: ");
			listaFuncionarios.append(atribuicao.getFuncionario().getCargo());
			listaFuncionarios.append(" Papel: ");
			listaFuncionarios.append(atribuicao.getPapel());
			listaFuncionarios.append("\n");
		}
		return listaFuncionarios.toString();
	}

	public String exibirFuncionariosTarefasAtrasadas() {
		StringBuilder funcionariosTarefasAtrasadas = new StringBuilder(
				"-----------------------------Lista de funcionarios com tarefas atrasadas-----------------------------\n");

		for (Atribuicao atribuicao : atribuicoes) {
			for (Tarefa tarefa : atribuicao.getFuncionario().getTarefas()) {
				if (tarefa.getEstado().getCodigo() == 3) {
					funcionariosTarefasAtrasadas.append(tarefa.getFuncionario().getUsuarioID());
					funcionariosTarefasAtrasadas.append(" - ");
					funcionariosTarefasAtrasadas.append(tarefa.getFuncionario().getNome());
					funcionariosTarefasAtrasadas.append("\n");
				}
			}
		}
		return funcionariosTarefasAtrasadas.toString();
	}

	public String exibirGerente() {
		StringBuilder exibeGerente = new StringBuilder(
				"-----------------------------Geremte do projeto-----------------------------\n");

		for (Atribuicao atribuicao : atribuicoes) {
			if (atribuicao.getPapel() == Papel.GERENTE) {
				exibeGerente.append(atribuicao.getFuncionario().getUsuarioID());
				exibeGerente.append(" - ");
				exibeGerente.append(atribuicao.getFuncionario().getNome());
			}
		}
		return exibeGerente.toString();
	}
}