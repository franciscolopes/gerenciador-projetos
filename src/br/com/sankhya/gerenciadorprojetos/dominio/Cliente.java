/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 19/02/2019
Objetivo sucinto da classe: Possui as caracteristicas de um cliente do programa
Escopo do projeto: https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/
package br.com.sankhya.gerenciadorprojetos.dominio;

import java.io.Serializable;

public class Cliente extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private String email;
	private String telefone;
	private Endereco endereco = new Endereco();
	
	public Cliente() { }

	public Cliente(Integer usuarioID, String nome, String cpf, String email, String telefone, Endereco endereco) {
		super(usuarioID, nome, cpf);
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco; 
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
		return "Cliente [usuarioID=" + getUsuarioID() + ", nome=" + getNome() + ", cpf=" + getCpf() + ", email=" + getEmail() + ", telefone=" + getTelefone() + ", endereco={" + this.endereco + "}]";
	}
}
