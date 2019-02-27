package br.com.sankhya.gerenciadorprojetos.dominio;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.sankhya.gerenciadorprojetos.enums.Papel;

public class Atribuicao implements Serializable {

	private static final long serialVersionUID = 1L;
	private int qtdeHoras;
	private BigDecimal precoHora;
	private Equipe equipe;
	private Funcionario funcionario;
	private Integer papel;

	public Atribuicao() {
	}

	public Atribuicao(int qtdeHoras, BigDecimal precoHora, Equipe equipe, Funcionario funcionario, Papel papel) {
		super();
		this.qtdeHoras = qtdeHoras;
		this.precoHora = precoHora;
		this.equipe = equipe;
		this.funcionario = funcionario;
		this.papel = papel.getCodigo();
	}

	public int getQtdeHoras() {
		return qtdeHoras;
	}

	public void setQtdeHoras(int qtdeHoras) {
		this.qtdeHoras = qtdeHoras;
	}

	public BigDecimal getPrecoHora() {
		return precoHora;
	}

	public void setPrecoHora(BigDecimal precoHora) {
		this.precoHora = precoHora;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Papel getPapel() {
		return Papel.toEnum(papel);
	}

	public void setPapel(Papel papel) {
		this.papel = papel.getCodigo();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((equipe == null) ? 0 : equipe.hashCode());
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
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
		Atribuicao other = (Atribuicao) obj;
		if (equipe == null) {
			if (other.equipe != null)
				return false;
		} else if (!equipe.equals(other.equipe))
			return false;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Atribuicao [qtdeHoras=" + qtdeHoras + ", precoHora=" + precoHora + ", equipe=" + equipe
				+ ", funcionario=" + funcionario + "]";
	}
	
	public BigDecimal calcularPrecoTotal() {
		return new BigDecimal(qtdeHoras).multiply(precoHora);
	}
}