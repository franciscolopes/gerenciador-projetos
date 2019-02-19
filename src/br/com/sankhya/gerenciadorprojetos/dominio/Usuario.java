/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 19/02/2019
Objetivo sucinto da classe: Servir como superclasse para futuras implementações
Escopo do projeto: https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/
package br.com.sankhya.gerenciadorprojetos.dominio;

import java.io.Serializable;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer usuarioID;
	private String nome;
	private String cpf;
	
	public Usuario() { }

	public Usuario(Integer usuarioID, String nome, String cpf) {
		super();
		this.usuarioID = usuarioID;
		this.nome = nome;
		this.cpf = cpf;
	}

	public Integer getUsuarioID() {
		return usuarioID;
	}

	public void setUsuarioID(Integer usuarioID) {
		this.usuarioID = usuarioID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuarioID == null) ? 0 : usuarioID.hashCode());
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
		Usuario other = (Usuario) obj;
		if (usuarioID == null) {
			if (other.usuarioID != null)
				return false;
		} else if (!usuarioID.equals(other.usuarioID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [usuarioID=" + usuarioID + ", nome=" + nome + ", cpf=" + cpf + "]";
	}
}
