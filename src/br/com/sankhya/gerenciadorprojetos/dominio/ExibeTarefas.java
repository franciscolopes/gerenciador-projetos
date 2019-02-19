/*
Nome do autor: Ezequiel de Oliveira Sant'Ana
Data de criação do arquivo: 19/02/2019
Objetivo sucinto da classe: Cria uma interface para implements em Funcionario e Projeto.java
Escopo do projeto:  https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/
package br.com.sankhya.gerenciadorprojetos.dominio;

import java.util.Date;
import java.util.List;

interface ExibeTarefas {

	List<Tarefa> exibirTodasTarefas();

	List<Tarefa> exibirTarefasPendentes();

	List<Tarefa> exibirTarefasConcluidas();

	List<Tarefa> exibirTarefasAtrasadas();

	List<Tarefa> exibirTarefasParaEntregarAte(Date data);

}
