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
import java.util.List;

public class Funcionario extends Usuario implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private String cargo;
	private BigDecimal salario;
	private List<Tarefa> tarefas = new ArrayList<>();
	
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		return true;
	}

	@Override
	public String toString() { 
		return "Funcionario [usuarioID= " + getUsuarioID() + ", nome=" + getNome() + ", cpf=" + getCpf() + ", cargo=" + cargo + ", salario=" + salario + ", tarefas=" + tarefas + "]";
	}
	
	
}
