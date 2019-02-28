/*
Nome do autor: Ezequiel de Oliveira Sant'Ana
Data de criacaoo do arquivo: 19/02/2019
Objetivo sucinto da classe: Cria classe Projeto que implementa metodos da interface ExibeTarefas
Escopo do projeto:  https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/

package br.com.sankhya.gerenciadorprojetos.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import br.com.sankhya.gerenciadorprojetos.enums.EstadoProjeto;

public class Projeto implements ExibeTarefas, Serializable {

	private static final long serialVersionUID = 1L;
	private Integer projetoID;
	private String nome;
	private String objetivoInteligente;
	private Date dataInicio;
	private Date dataFim;
	private Integer status;
	private Cliente cliente;
	private Equipe equipe;
	private Produto produto;

	public Projeto() {

	}

	public Projeto(Integer projetoID, String nome, String objetivoInteligente, Date dataInicio, Date dataFim,
			EstadoProjeto status, Cliente cliente) {
		this.projetoID = projetoID;
		this.nome = nome;
		this.objetivoInteligente = objetivoInteligente;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.status = status.getCodigo();
		this.cliente = cliente;
		
	}

	public Integer getProjetoID() {
		return projetoID;
	}

	public void setProjetoID(Integer projetoID) {
		this.projetoID = projetoID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObjetivoInteligente() {
		return objetivoInteligente;
	}

	public void setObjetivoInteligente(String objetivoInteligente) {
		this.objetivoInteligente = objetivoInteligente;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public EstadoProjeto getStatusProjeto() {
		return EstadoProjeto.toEnum(status);
	}

	public void setStatusProjeto(EstadoProjeto Status) {
		this.status = Status.getCodigo();
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((projetoID == null) ? 0 : projetoID.hashCode());
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
		Projeto other = (Projeto) obj;
		if (projetoID == null) {
			if (other.projetoID != null)
				return false;
		} else if (!projetoID.equals(other.projetoID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Projeto [IDCliente=" + cliente.getUsuarioID() + ", nomeCliente=" + cliente.getNome() + ", projetoID=" + projetoID + ", nome=" + nome + ", objetivoInteligente=" + objetivoInteligente
				+ ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", status=" + status + "]";
	}

	@Override
	public String exibirTodasTarefas() {
		StringBuffer todasTarefas = new StringBuffer(" ");
		for (Atribuicao atribuicoesLista : equipe.getAtribuicoes()){
			todasTarefas.append(atribuicoesLista.getFuncionario().exibirTodasTarefas());
		}
		return todasTarefas.toString();
	}

	@Override
	public String exibirTarefasPendentes() {
		StringBuffer todasTarefas = new StringBuffer(" ");
		for (Atribuicao atribuicoesLista : equipe.getAtribuicoes()){
			todasTarefas.append(atribuicoesLista.getFuncionario().exibirTarefasPendentes());
		}
		return todasTarefas.append("\n").toString();
	}

	@Override
	public String exibirTarefasConcluidas() {
		StringBuffer todasTarefas = new StringBuffer(" ");
		for (Atribuicao atribuicoesLista : equipe.getAtribuicoes()){
			todasTarefas.append(atribuicoesLista.getFuncionario().exibirTarefasConcluidas()).append("\n");
		}
		return todasTarefas.toString();
	}

	@Override
	public String exibirTarefasAtrasadas() {
		StringBuffer todasTarefas = new StringBuffer(" ");
		for (Atribuicao atribuicoesLista : equipe.getAtribuicoes()){
			todasTarefas.append(atribuicoesLista.getFuncionario().exibirTarefasAtrasadas()).append("\n");
		}
		return todasTarefas.toString();
	}

	@Override
	public String exibirTarefasParaEntregarAte(Date data) {
		StringBuffer todasTarefas = new StringBuffer(" ");
		for (Atribuicao atribuicoesLista : equipe.getAtribuicoes()){
			todasTarefas.append(atribuicoesLista.getFuncionario().exibirTarefasParaEntregarAte(data)).append("\n");
		}
		return todasTarefas.toString();
	}
	
	public BigDecimal calcularCustoTotal() {
		
		BigDecimal custoTotal = new BigDecimal(0);
		
		for(Atribuicao atribuicao : equipe.getAtribuicoes()) {
			BigDecimal custoAtribuicao = atribuicao.calcularPrecoTotal();
			custoTotal = custoTotal.add(custoAtribuicao);
		}
		return custoTotal;
	}
	
}