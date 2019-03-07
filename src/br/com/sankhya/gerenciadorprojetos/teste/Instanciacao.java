/*
Nome do autor: João Victor Oliveira Marques 
Data de criação do arquivo: 01/03/2019
Objetivo sucinto da classe: Testar todas as classes seguindo o padrao de fluxo inicial.
Escopo do projeto: https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
*/

package br.com.sankhya.gerenciadorprojetos.teste;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import br.com.sankhya.gerenciadorprojetos.dominio.Atribuicao;
import br.com.sankhya.gerenciadorprojetos.dominio.Cliente;
import br.com.sankhya.gerenciadorprojetos.dominio.Endereco;
import br.com.sankhya.gerenciadorprojetos.dominio.Equipe;
import br.com.sankhya.gerenciadorprojetos.dominio.Funcionario;
import br.com.sankhya.gerenciadorprojetos.dominio.Produto;
import br.com.sankhya.gerenciadorprojetos.dominio.Projeto;
import br.com.sankhya.gerenciadorprojetos.dominio.Requisito;
import br.com.sankhya.gerenciadorprojetos.dominio.Tarefa;
import br.com.sankhya.gerenciadorprojetos.enums.EstadoProjeto;
import br.com.sankhya.gerenciadorprojetos.enums.EstadoTarefa;
import br.com.sankhya.gerenciadorprojetos.enums.Papel;
import br.com.sankhya.gerenciadorprojetos.enums.Prioridade;

public class Instanciacao {

	public static void main(String[] args) throws Exception {

		// Instanciacao e formatacao de datas
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		Date dataHoje = formatador.parse(formatador.format(new Date()));
		Date dataDoisDiasAtras = formatador.parse(formatador.format(new Date(dataHoje.getTime() - (1728 * 100000))));
		Date dataQuatroDiasAtras = formatador
				.parse(formatador.format(new Date(dataHoje.getTime() - (1728 * 100000) * 2)));
		Date dataDoisDiasFrente = formatador.parse(formatador.format(new Date(dataHoje.getTime() + (1728 * 100000))));

		// Fluxo Cadastro de Cliente
		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente1 = new Cliente(1, "Jorge Matagal", "328486528-94", "mataGales@net.com", "(34) 9898-3434");
		Cliente cliente2 = new Cliente(4, "Vitoria Lemes", "132898471-96", "vivi@gmail.com", "(58) 9640-0071");
		Cliente cliente3 = new Cliente(3, "John deLonge", "465981567-84", "jonhjonh@outlook.com", "(11) 8814-1836");
		Cliente cliente4 = new Cliente(2, "Phabio Estarvolds", "684987881-54", "estarvolds@gmail.com", "(16) 9768-9627");
		Cliente cliente5 = new Cliente(5, "Jose Antonio", "021545486-86", "kiboa@inesq.com", "(34) 8841-6550");
		clientes.addAll(Arrays.asList(cliente1, cliente2, cliente3, cliente4, cliente5));

		// Cria e seta enderecos
		Endereco endereco1 = new Endereco(11, "Rua Mato Grosso", 666, "Esquina com a Quarta", "Lidice", "38407615",
				"Araguari", "Minas Gerais");
		cliente1.setEndereco(endereco1);
		Endereco endereco2 = new Endereco(12, "Rua Angelo Bortolai", 578, "Em frente a imobiliaria", "Centro",
				"38969454 ", "Torrinha", "Sao Paulo");
		cliente2.setEndereco(endereco2);
		Endereco endereco3 = new Endereco(13, "Av. China", 330, "Logo apos farmacia Bela", "Santa Monica",
				"38384864", "Pedrinopolio", "Mato Grosso do Leste");
		cliente3.setEndereco(endereco3);
		Endereco endereco4 = new Endereco(14, "Av. Francisco Ribeiro", 237, "Lado a praca", "Morumbi",
				"38404658", "Telemaco Borba", "Parana");
		cliente4.setEndereco(endereco4);
		Endereco endereco5 = new Endereco(15, "Rua Jamil Anbraao", 140, "Em frente o ponto",
				"Segismundo Pereira", "38408306", "Uberlandia", "Segismundo Pereira");
		cliente5.setEndereco(endereco5);

		// Fluxo Listar Clientes
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getUsuarioID() + " " + cliente.getNome());
		}

		// Fluxo Detalhes de Clientes - Dados pessoais
		System.out.println(cliente1);
		System.out.println(cliente2);
		System.out.println(cliente3);
		System.out.println(cliente4);
		System.out.println(cliente5);

		// Fluxo Detalhes de Clientes - Projetos do cliente
		// Fluxo Menu de Projetos - Cadastrar projetos
		Projeto projeto1 = new Projeto(21, "Market Atzap", "Criar um chat conversa para o mercado de trabalho",
				dataDoisDiasAtras, dataHoje, EstadoProjeto.EM_ANDAMENTO, cliente1);
		Projeto projeto2 = new Projeto(22, "Manager Liber", "Desenolver uma replicação de uma biblioteca",
				dataQuatroDiasAtras, dataDoisDiasAtras, EstadoProjeto.EM_ANDAMENTO, cliente1);
		Projeto projeto3 = new Projeto(23, "Calculate Back-ENd", "Software de uma calculadora feita com Java",
				dataDoisDiasAtras, dataHoje, EstadoProjeto.CONCLUIDO, cliente1);
		Projeto projeto4 = new Projeto(24, "Fortnite Lite", "Otimizar o game - Fortnite", dataDoisDiasAtras, dataHoje,
				EstadoProjeto.EM_ANDAMENTO, cliente1);
		Projeto projeto5 = new Projeto(25, "Grabs Hero", "Buscar picos para dar uma stritada", dataDoisDiasAtras,
				dataHoje, EstadoProjeto.CONCLUIDO, cliente1);

		cliente1.getProjetos().addAll(Arrays.asList(projeto1, projeto2, projeto3, projeto4, projeto5));

		// Fluxo Cadastro do Projeto - Cadastro de Produto e Requisitos
		Produto produto1 = new Produto(31, "Market Place", "Mercado on-line, livre de filas e lentidao");

		Requisito requisito1 = new Requisito(41, "Criar uma plataforma rapida", Prioridade.ALTA, produto1);
		Requisito requisito2 = new Requisito(42, "Comprar a lisenciasao on-line", Prioridade.MEDIA, produto1);
		Requisito requisito3 = new Requisito(43, "Fazer relatorio do projeto", Prioridade.BAIXA, produto1);

		produto1.getRequisitos().addAll(Arrays.asList(requisito1, requisito2, requisito3));

		// Fluxo Cadastro de Produto e Requisitos - Cadastro de Equipe e Tarefas
		Funcionario funcionario1 = new Funcionario(51, "Leo Cruz", "021545486-36", "Desenvolvedor",
				new BigDecimal(1.800));
		Funcionario funcionario2 = new Funcionario(52, "Carmen Pires", "054987362-99", "Analista",
				new BigDecimal(2.100));
		Funcionario funcionario3 = new Funcionario(53, "Dereck Tonson", "031647987-45", "Teste", new BigDecimal(1.500));
		Funcionario funcionario4 = new Funcionario(54, "Darlon Marx", "698785216-55", "Arquiteto",
				new BigDecimal(2.400));
		Funcionario funcionario5 = new Funcionario(55, "Uilton Baptist", "315875465-11", "Desenvolvedor",
				new BigDecimal(1.500));

		Tarefa tarefa1 = new Tarefa(61, "Abrir a comunicacao entre o cliente e servidor", dataHoje,
				EstadoTarefa.CONCLUIDA, funcionario1);
		Tarefa tarefa2 = new Tarefa(62, "Analisar requisicao com o cliente", dataDoisDiasFrente, EstadoTarefa.ATRASADA,
				funcionario2);
		Tarefa tarefa3 = new Tarefa(63, "Realizar testes manuais e automaticos do projeto", dataHoje,
				EstadoTarefa.PENDENTE, funcionario3);
		Tarefa tarefa4 = new Tarefa(64, "Organizar e estruturar o projeto", dataQuatroDiasAtras, EstadoTarefa.CONCLUIDA,
				funcionario4);
		Tarefa tarefa5 = new Tarefa(65, "Configurar o banco de dados", dataDoisDiasAtras, EstadoTarefa.CONCLUIDA,
				funcionario5);
		Tarefa tarefa6 = new Tarefa(66, "Modificar o lado Front-End", dataDoisDiasAtras, EstadoTarefa.ATRASADA,
				funcionario1);
		Tarefa tarefa7 = new Tarefa(67, "Testar os primeiros passos do projeto ", dataDoisDiasAtras,
				EstadoTarefa.ATRASADA, funcionario3);
		Tarefa tarefa8 = new Tarefa(68, "Criar uma segunda opcao para o andamento projeto", dataDoisDiasAtras,
				EstadoTarefa.ATRASADA, funcionario4);
		Tarefa tarefa9 = new Tarefa(69, "Auxiliar a mudanca no lado Front-End do projeto", dataDoisDiasAtras,
				EstadoTarefa.ATRASADA, funcionario5);

		funcionario1.getTarefas().addAll(Arrays.asList(tarefa1, tarefa6));
		funcionario2.getTarefas().addAll(Arrays.asList(tarefa2));
		funcionario3.getTarefas().addAll(Arrays.asList(tarefa3, tarefa7));
		funcionario4.getTarefas().addAll(Arrays.asList(tarefa4, tarefa8));
		funcionario5.getTarefas().addAll(Arrays.asList(tarefa5, tarefa9));

		Equipe equipe1 = new Equipe(71, "DevOps");

		Atribuicao atribuicao1 = new Atribuicao(14, equipe1, funcionario1, Papel.COLABORADOR);
		Atribuicao atribuicao2 = new Atribuicao(1, equipe1, funcionario2, Papel.COLABORADOR);
		Atribuicao atribuicao3 = new Atribuicao(3, equipe1, funcionario3, Papel.COLABORADOR);
		Atribuicao atribuicao4 = new Atribuicao(5, equipe1, funcionario4, Papel.GERENTE);
		Atribuicao atribuicao5 = new Atribuicao(17, equipe1, funcionario5, Papel.COLABORADOR);

		funcionario1.getAtribuicoes().addAll(Arrays.asList(atribuicao1));
		funcionario2.getAtribuicoes().addAll(Arrays.asList(atribuicao2));
		funcionario3.getAtribuicoes().addAll(Arrays.asList(atribuicao3));
		funcionario4.getAtribuicoes().addAll(Arrays.asList(atribuicao4));
		funcionario5.getAtribuicoes().addAll(Arrays.asList(atribuicao5));

		equipe1.getAtribuicoes().addAll(Arrays.asList(atribuicao1, atribuicao2, atribuicao3, atribuicao4, atribuicao5));

		equipe1.setProjeto(projeto1);
		projeto1.setEquipe(equipe1);

		// Fluxo Menu de Projetos - Listar Projetos
		// Fluxo Informacoes do Projeto - Produto
		System.out.println(produto1.exibirTodosRequisitos());

		System.out.println(produto1.exibirRequisitosPorPrioridade(Prioridade.ALTA));
		System.out.println(produto1.exibirRequisitosPorPrioridade(Prioridade.MEDIA));
		System.out.println(produto1.exibirRequisitosPorPrioridade(Prioridade.BAIXA));

		// Fluxo Informacoes do Projeto - Equipe
		System.out.println(equipe1.exibirFuncionarios());
		System.out.println(equipe1.exibirFuncionariosTarefasAtrasadas());

		// Fluxo Informacoes do Projeto - Tarefas
		System.out.println(projeto1.exibirTodasTarefas());
		System.out.println(projeto1.exibirTarefasAtrasadas());
	}
}