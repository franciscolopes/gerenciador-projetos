package br.com.sankhya.gerenciadorprojetos.dominio;

import java.io.Serializable;

public class Equipe implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer equipeID;
	private String nome;

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
}