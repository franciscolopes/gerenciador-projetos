/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 19/02/2019
Objetivo sucinto da classe: Indicar o endereco do cliente
Escopo do projeto: https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/
package br.com.sankhya.gerenciadorprojetos.dominio;

import java.io.Serializable;

public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer enderecoID;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	private Cliente cliente;
	
	public Endereco() { }
	
	public Endereco(Integer enderecoID, String logradouro, Integer numero, String complemento, String bairro,
			String cep, String cidade, String estado) {
		super();
		this.enderecoID = enderecoID;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Integer getEnderecoID() {
		return enderecoID;
	}
	
	public void setEnderecoID(Integer enderecoID) {
		this.enderecoID = enderecoID;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enderecoID == null) ? 0 : enderecoID.hashCode());
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
		Endereco other = (Endereco) obj;
		if (enderecoID == null) {
			if (other.enderecoID != null)
				return false;
		} else if (!enderecoID.equals(other.enderecoID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Endereco [idResidente=" + cliente.getUsuarioID() + ", nomeResidente=" + cliente.getNome() + ", enderecoID=" + enderecoID + ", logradouro=" + logradouro + ", numero=" + numero
				+ ", complemento=" + complemento + ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade
				+ ", estado=" + estado + "]";
	}
}