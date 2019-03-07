/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 19/02/2019
Objetivo sucinto da classe: Simular o funcionamento de um cliente deste programa.
Escopo do projeto: https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/
package br.com.sankhya.gerenciadorprojetos.dominio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.sankhya.gerenciadorprojetos.enums.EstadoProjeto;

public class Cliente extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private String email;
	private String telefone;
	private Endereco endereco;
	private List<Projeto> projetos = new ArrayList<>();

	public Cliente() {
	}

	public Cliente(Integer usuarioID, String nome, String cpf, String email, String telefone) {
		super(usuarioID, nome, cpf);
		this.email = email;
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
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
	public String toString() {
		return "Cliente [usuarioID=" + getUsuarioID() + ", nome=" + getNome() + ", cpf=" + getCpf() + ", email="
				+ getEmail() + ", telefone=" + getTelefone() + ", endereco={" + this.endereco + "}]";
	}

	public String exibirTodosProjetos() {
		StringBuffer strProjetos = new StringBuffer("  ID \t|\t NOME DO PROJETO \t|\t STATUS \t|\t");

		for (Projeto projeto : projetos) {
			strProjetos.append("\n  " + projeto.getProjetoID() + " \t|\t " + projeto.getNome().subSequence(0, 15));
			strProjetos.append(" \t|\t " + projeto.getStatusProjeto() + " \t|\t ");
		}

		String todosProjetos = strProjetos.toString();
		return todosProjetos;
	}

	public String exibirProjetosConcluidos() {
		StringBuffer strProjetos = new StringBuffer("  ID \t|\t NOME DO PROJETO \t|\t STATUS \t|\t");

		for (Projeto projetoAtual : projetos) {
			if (projetoAtual.getStatusProjeto().getCodigo() == 2) {
				strProjetos.append("\n  " + projetoAtual.getProjetoID() + " \t|\t " + projetoAtual.getNome().subSequence(0, 15));
				strProjetos.append(" \t|\t " + projetoAtual.getStatusProjeto() + " \t|\t ");
			}
		}

		String projetosConcluidos = strProjetos.toString();
		return projetosConcluidos;
	}

	public String exibirProjetosAtrasados() throws Exception {
		StringBuffer strProjetos = new StringBuffer("  ID \t|\t NOME DO PROJETO \t|\t STATUS \t|\t");
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

		Date dataAtual = formatador.parse(formatador.format(new Date()));

		for (Projeto projetoAtual : projetos) {
			if (dataAtual.compareTo(projetoAtual.getDataFim()) > 0
					&& projetoAtual.getStatusProjeto().getCodigo() == 1) {
				strProjetos.append("\n  " + projetoAtual.getProjetoID() + " \t|\t " + projetoAtual.getNome().subSequence(0, 15));
				strProjetos.append(" \t|\t " + projetoAtual.getStatusProjeto() + " \t|\t ");
			}
		}

		String projetosAtrasados = strProjetos.toString();
		return projetosAtrasados;
	}

	public String exibirProjetosEmAndamento() {
		StringBuffer strProjetos = new StringBuffer("  ID \t|\t NOME DO PROJETO \t|\t STATUS \t|\t");

		for (Projeto projetoAtual : projetos) {
			if (projetoAtual.getStatusProjeto().getCodigo() == 1) {
				strProjetos.append("\n  " + projetoAtual.getProjetoID() + " \t|\t " + projetoAtual.getNome().subSequence(0, 15));
				strProjetos.append(" \t|\t " + projetoAtual.getStatusProjeto() + " \t|\t ");
			}
		}

		String projetosEmAndamento = strProjetos.toString();
		return projetosEmAndamento;
	}
}
