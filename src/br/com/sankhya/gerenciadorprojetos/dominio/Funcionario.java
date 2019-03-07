/*
Nome do autor: Fábio Augusto Amaro Jaime
Data de criação do arquivo: 19/02/2019
Objetivo sucinto da classe: Manipular dados, estado e comportamento de um objeto funcionario.
Escopo do projeto: https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/

package br.com.sankhya.gerenciadorprojetos.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.sankhya.gerenciadorprojetos.enums.EstadoTarefa;

public class Funcionario extends Usuario implements ExibeTarefas, Serializable {

	private static final long serialVersionUID = 1L;
	private String cargo;
	private BigDecimal salario;
	private List<Tarefa> tarefas = new ArrayList<>();
	private Set<Atribuicao> atribuicoes = new HashSet<>();

	public Funcionario() {
		super();
	}

	public Funcionario(Integer usuarioID, String nome, String cpf, String cargo, BigDecimal salario) {
		super(usuarioID, nome, cpf);
		this.cargo = cargo;
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
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
		int result = super.hashCode();
		result = prime * result + ((getUsuarioID() == null) ? 0 : getUsuarioID().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (getUsuarioID() == null) {
			if (other.getUsuarioID() != null)
				return false;
		} else if (!getUsuarioID().equals(other.getUsuarioID()))
			return false;
		return true;
	}

	@Override
	public String exibirTodasTarefas() {
		StringBuffer listaTarefas = new StringBuffer("  ID  \t|\t DESCRICAO \t\t|\t DATA ENTREGA \t\t\t|\t STATUS \t|");

		for (Tarefa colecaoDeTarefas : tarefas) {
			listaTarefas.append("\n").append("  " + colecaoDeTarefas.getTarefaID()).append(" \t|\t ")
					.append(colecaoDeTarefas.getDescricao().subSequence(0, 15)).append(" \t|\t ").append(colecaoDeTarefas.getDataEntrega())
					.append(" \t|\t ").append(colecaoDeTarefas.getEstado()).append(" \t|\t ");
		}
		listaTarefas.append("\n");
		return listaTarefas.toString();
	}

	@Override
	public String exibirTarefasPendentes() {
		StringBuffer listaTarefas = new StringBuffer("  ID  \t|\t DESCRICAO \t\t|\t DATA ENTREGA \t\t\t|\t STATUS \t|");

		for (Tarefa colecaoDeTarefas : tarefas) {
			if (colecaoDeTarefas.getEstado().getCodigo() == EstadoTarefa.PENDENTE.getCodigo()) {
				listaTarefas.append("\n").append("  " + colecaoDeTarefas.getTarefaID()).append(" \t|\t ")
						.append(colecaoDeTarefas.getDescricao().subSequence(0, 15)).append(" \t|\t ")
						.append(colecaoDeTarefas.getDataEntrega()).append(" \t|\t ")
						.append(colecaoDeTarefas.getEstado()).append(" \t|\t ");
			}
		}
		listaTarefas.append("\n");
		return listaTarefas.toString();
	}

	@Override
	public String exibirTarefasConcluidas() {
		StringBuffer listaTarefas = new StringBuffer("  ID  \t|\t DESCRICAO \t\t|\t DATA ENTREGA \t\t\t|\t STATUS \t|");

		for (Tarefa colecaoDeTarefas : tarefas) {
			if (colecaoDeTarefas.getEstado().getCodigo() == EstadoTarefa.CONCLUIDA.getCodigo()) {
				listaTarefas.append("\n").append(" " + colecaoDeTarefas.getTarefaID()).append(" \t|\t ")
						.append(colecaoDeTarefas.getDescricao().subSequence(0, 15)).append(" \t|\t ")
						.append(colecaoDeTarefas.getDataEntrega()).append(" \t|\t ")
						.append(colecaoDeTarefas.getEstado()).append(" \t|\t ");
			}
		}
		listaTarefas.append("\n");
		return listaTarefas.toString();
	}

	@Override
	public String exibirTarefasAtrasadas() {
		StringBuffer listaTarefas = new StringBuffer("  ID  \t|\t DESCRICAO \t\t|\t DATA ENTREGA \t\t\t|\t STATUS \t|");

		for (Tarefa colecaoDeTarefas : tarefas) {
			if (colecaoDeTarefas.getEstado().getCodigo() == EstadoTarefa.ATRASADA.getCodigo()) {
				listaTarefas.append("\n").append(" " + colecaoDeTarefas.getTarefaID()).append(" \t|\t ")
						.append(colecaoDeTarefas.getDescricao().subSequence(0, 15)).append(" \t|\t ")
						.append(colecaoDeTarefas.getDataEntrega()).append(" \t|\t ")
						.append(colecaoDeTarefas.getEstado()).append(" \t|\t ");
			}
		}
		listaTarefas.append("\n");
		return listaTarefas.toString();
	}

	@Override
	public String exibirTarefasParaEntregarAte(Date data) {
		StringBuffer listaTarefas = new StringBuffer("  ID  \t|\t DESCRICAO \t\t|\t DATA ENTREGA \t\t\t|\t STATUS \t|");

		for (Tarefa colecaoDeTarefas : tarefas) {
			if (colecaoDeTarefas.getDataEntrega().compareTo(data) <= 0) {
				listaTarefas.append("\n").append(" " + colecaoDeTarefas.getTarefaID()).append(" \t|\t ")
						.append(colecaoDeTarefas.getDescricao().subSequence(0, 15)).append(" \t|\t ")
						.append(colecaoDeTarefas.getDataEntrega()).append(" \t|\t ")
						.append(colecaoDeTarefas.getEstado()).append(" \t|\t ");
			}
		}
		listaTarefas.append("\n");
		return listaTarefas.toString();
	}

	@Override
	public String toString() {
		StringBuilder retorno = new StringBuilder();
		retorno.append("Cargo= ");
		retorno.append(cargo);
		retorno.append(", salario=");
		retorno.append(salario);
		retorno.append(", atribuicoes=");
		for (Atribuicao atribuicao : atribuicoes) {
			retorno.append("Nome da equipe= ");
			retorno.append(atribuicao.getEquipe().getNome());

		}
		return retorno.toString();
	}

}
