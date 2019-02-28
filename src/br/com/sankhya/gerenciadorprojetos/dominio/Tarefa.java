/*
Nome do autor: Fábio Augusto Amaro Jaime
Data de criação do arquivo: 19/02/2019
Objetivo sucinto da classe: Manipular dados, estado e comportamento de um objeto Tarefa.
Escopo do projeto: https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/

package br.com.sankhya.gerenciadorprojetos.dominio;

import java.io.Serializable;
import java.util.Date;

import br.com.sankhya.gerenciadorprojetos.enums.EstadoTarefa;

public class Tarefa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer tarefaID;
	private String descricao;
	private Date dataEntrega;
	private Integer estado;
	private Funcionario funcionario;
	
	public Tarefa() {
		super();
	}

	public Tarefa(Integer tarefaID, String descricao, Date dataEntrega, EstadoTarefa estado, Funcionario funcionario) {
		super();
		this.tarefaID = tarefaID;
		this.descricao = descricao;
		this.dataEntrega = dataEntrega;
		this.estado = estado.getCodigo();
		this.funcionario = funcionario;
	}

	public Integer getTarefaID() {
		return tarefaID;
	}

	public void setTarefaID(Integer tarefaID) {
		this.tarefaID = tarefaID;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	
	public EstadoTarefa getEstado() {
		return EstadoTarefa.toEnum(estado);
	}

	public void setEstado(EstadoTarefa estado) {
		this.estado = estado.getCodigo();
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEntrega == null) ? 0 : dataEntrega.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((tarefaID == null) ? 0 : tarefaID.hashCode());
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
		Tarefa other = (Tarefa) obj;
		if (dataEntrega == null) {
			if (other.dataEntrega != null)
				return false;
		} else if (!dataEntrega.equals(other.dataEntrega))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (tarefaID == null) {
			if (other.tarefaID != null)
				return false;
		} else if (!tarefaID.equals(other.tarefaID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tarefa [tarefaID=" + tarefaID + ", descricao=" + descricao + ", dataEntrega=" + dataEntrega
				+ ", estado=" + EstadoTarefa.toEnum(estado) + ", funcionario=" + funcionario + "]";
	}
	
	public void atualizarStatus(EstadoTarefa status) {
		setEstado(status);
	}
}
