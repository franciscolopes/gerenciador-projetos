/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 19/02/2019
Objetivo sucinto da classe: Gerencia os dados e os menus da aplicação
Escopo do projeto: https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
Sumário:
	Main - Código ^(P6tO
	Menu Principal - Código wbo$Lp
 	Menu Cadastrar Cliente - Código 5tg:h&
 	Menu Listar Clientes - Código 2d:U5!
 	Menu Detalhes do Cliente - Código QA)DWd
 	Menu Dados Pessoais - Código dtzsP+
 	Menu Projetos - Código !E.U^x
 	Menu Cadastro de Projeto - Código Lq>?Ie
	Menu Cadastro do Produto e Requisitos - Código duxkX0
	Menu Cadastro de Equipe e Tarefas - Código ?<&H$#
	Menu Listar Projetos - Código :+%8$R
	Menu Exibicao de Projetos - Código >de1DM
	Menu Informações do Projeto - Código YJYF|&
	Menu Tarefas do Projeto - Código D!)maL
	Menu Produto e Requisitos do Projeto - Código k)Lf(A
	Menu Equipe do Projeto - Código T9a(xJ
	Menu Funcionário do Projeto - Código Llc*q[
*/
package br.com.sankhya.gerenciadorprojetos.dominio;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.sankhya.gerenciadorprojetos.enums.EstadoProjeto;
import br.com.sankhya.gerenciadorprojetos.enums.EstadoTarefa;
import br.com.sankhya.gerenciadorprojetos.enums.Papel;
import br.com.sankhya.gerenciadorprojetos.enums.Prioridade;

public class AplicacaoGerenciadorProjetos {
	public static List<Cliente> clientes = new ArrayList<>();     
	public static Cliente cliente;
	public static Projeto projeto;
	public static Equipe equipe;
	public static Funcionario funcionario;
	public static Scanner leitor = new Scanner(System.in);
	public static Integer usuarioID = 1;
	public static Integer funcionarioID = 1;
	public static Integer enderecoID = 1;
	public static Integer projetoID = 1;
	public static Integer produtoID = 1;
	public static Integer equipeID = 1;
	public static Integer requisitoID = 1;
	public static Integer tarefaID = 1;
	public static SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy"); 
	
	// Menu Principal - Código wbo$Lp
	public static void menuPrincipal() {
		while(true) {
			System.out.println();
			System.out.println("[ Menu Principal ]");
			System.out.println("1.Cadastrar Cliente");
			if(clientes.size() >= 1) {
				System.out.println("2.Listar Clientes");
			}
			
			System.out.println();
			System.out.print("Escolha uma opção: ");
			int opcao = leitor.nextInt();
			leitor.nextLine();
			
			if(opcao == 1) {
				cadastrarCliente();
			} else if(opcao == 2 && clientes.size() >= 1) {
				listarClientes();
			}  else {
				System.out.println("opção inválida, tente novamente");
			}
		}
	}
	
	// Menu Cadastrar Cliente - Código 5tg:h&
	public static void cadastrarCliente() {
		while(true) {
			System.out.println();
			System.out.println("[ Cadastro de Cliente ]");
			System.out.println();
			
			System.out.print("Nome: ");
			String nome = leitor.nextLine();
			System.out.print("CPF: ");
			String cpf = leitor.nextLine();
			System.out.print("E-mail: ");
			String email = leitor.nextLine();
			System.out.print("Telefone: ");
			String telefone = leitor.nextLine();
			
			System.out.println();
			System.out.print("Dados da Residência");
			System.out.println();
			System.out.println();
			
			System.out.print("Logradouro(Rua): ");
			String logradouro = leitor.nextLine();
			System.out.print("Número: ");
			Integer numero = leitor.nextInt();
			leitor.nextLine();
			System.out.print("Complemento: ");
			String complemento = leitor.nextLine();
			System.out.print("Bairro: ");
			String bairro = leitor.nextLine();
			System.out.print("CEP: ");
			String cep = leitor.nextLine();
			System.out.print("Cidade: ");
			String cidade = leitor.nextLine();
			System.out.print("Estado: ");
			String estado = leitor.nextLine();
			
			Endereco endereco = new Endereco(enderecoID, logradouro, numero, complemento, bairro, cep, cidade, estado);
			Cliente cliente = new Cliente(usuarioID, nome, cpf, email, telefone);
			cliente.setEndereco(endereco);
			clientes.add(cliente);
			
			enderecoID++;
			usuarioID++;
			
			menuPrincipal();
		}
	}
	
	// Menu Listar Clientes - Código 2d:U5!
	public static void listarClientes() {
		while(true) {
			System.out.println();
			System.out.println("[ Lista de Clientes ]");
			System.out.println();
			
			for(Cliente cliente : clientes) {
				System.out.println(cliente.getUsuarioID() + " " + cliente.getNome());
			}
			
			System.out.println();
			System.out.print("Selecione um cliente por seu ID: ");
			int ID = leitor.nextInt();
			leitor.nextLine();
			try {
				cliente = clientes.get(ID - 1);
				detalhesDoCliente();
			} catch(Exception e) {
				System.out.println("ID inválido, insira um valor válido");
			}
		}
	}
	
	// Menu Detalhes do Cliente - Código QA)DWd
	public static void detalhesDoCliente() {
		while(true) {
			System.out.println();
			System.out.println("[ Detalhes do Cliente ]");
			System.out.println("1.Voltar ao menu principal");
			System.out.println("2.Dados pessoais");
			System.out.println("3.Projetos do cliente");
			System.out.println();
		
			System.out.print("Escolha uma opção: ");
			int opcao = leitor.nextInt();
			leitor.nextLine();
			
			if(opcao == 1) {
				menuPrincipal();
			} else if(opcao == 2) {
				dadosPessoais();
			} else if(opcao == 3) {
				projetos();
			}  else {
				System.out.println("opção inválida, tente novamente");
			}
		}
	}
	
	// Menu Dados Pessoais - Código dtzsP+
	public static void dadosPessoais() {
		System.out.println();
		System.out.println("[ Dados Pessoais ]");
		System.out.println();
		
		System.out.println("Nome: " + cliente.getNome());
		System.out.println("CPF: " + cliente.getCpf());
		System.out.println("E-mail: " + cliente.getEmail());
		System.out.println("Telefone: " + cliente.getTelefone());
		
		System.out.println();
		System.out.println("[ Dados da Residência ]");
		System.out.println();
		
		System.out.println("Logradouro(Rua): " + cliente.getEndereco().getLogradouro());
		System.out.println("Número: " + cliente.getEndereco().getNumero());
		System.out.println("Complemento: " + cliente.getEndereco().getComplemento());
		System.out.println("Bairro: " + cliente.getEndereco().getBairro());
		System.out.println("CEP: " + cliente.getEndereco().getCep());
		System.out.println("Cidade: " + cliente.getEndereco().getCidade());
		System.out.println("Estado: " + cliente.getEndereco().getEstado());
		
		while(true) {
			System.out.println();
			System.out.println("1.Voltar ao menu detalhes do cliente");
			System.out.println("2.Voltar ao menu principal");
			System.out.println();
		
			System.out.print("Escolha uma opção: ");
			int opcao = leitor.nextInt();
			leitor.nextLine();
			
			if(opcao == 1) {
				detalhesDoCliente();
			} else if(opcao == 2) {
				menuPrincipal();
			} else {
				System.out.println("opção inválida, tente novamente");
			}
		}
	}
	
	// Menu Projetos - Código !E.U^x
	public static void projetos() {
		while(true) {
			System.out.println();
			System.out.println("[ Menu de Projetos ]");
			System.out.println("1.Voltar ao menu detalhes do cliente");
			System.out.println("2.Cadastrar projeto");
			if(cliente.getProjetos().size() > 0) {
				System.out.println("3.Listar projetos");
			}
			System.out.println();
			
			System.out.print("Escolha uma opção: ");
			int opcao = leitor.nextInt();
			leitor.nextLine();
			
			if(opcao == 1) {
				detalhesDoCliente();
			} else if(opcao == 2) {
				cadastroDeProjeto();
			} else if(opcao == 3 && cliente.getProjetos().size() > 0) {
				listarProjetos();
			} else {
				System.out.println("opção inválida, tente novamente");
			}
		}
	}
	
	// Menu Cadastro de Projeto - Código Lq>?Ie
	public static void cadastroDeProjeto() {
		while(true) {
			System.out.println();
			System.out.println("[ Cadastro de Projeto ]");
			System.out.println();
			
			System.out.print("Nome: ");
			String nome = leitor.nextLine();
			System.out.print("Objetivo Inteligente: ");
			String objetivoInteligente = leitor.nextLine();

			try {
				System.out.print("Data de inicio no formato(dd/mm/aaaa): ");
				String dataInicioString = leitor.nextLine();
				Date dataInicio = formatadorData.parse(dataInicioString);
				
		 		System.out.print("Data de fim no formato(dd/mm/aaaa): ");
				String dataFimString = leitor.nextLine();
				Date dataFim = formatadorData.parse(dataFimString);
				
				Projeto projetoCriado = new Projeto(projetoID, nome, objetivoInteligente, dataInicio, dataFim , EstadoProjeto.toEnum(1), cliente);
				cliente.getProjetos().addAll(Arrays.asList(projetoCriado));
				cadastroDoProdutoERequisitos();
			} catch(Exception e) {
				System.out.println("Formato Incorreto de Data");
			}
		}
	}
	
	// Menu Cadastro do Produto e Requisitos - Código duxkX0
	public static void cadastroDoProdutoERequisitos() {
		System.out.println();
		System.out.println("[ Cadastro do Produto ]");
		System.out.println();
		
		System.out.print("Nome: ");
		String nome = leitor.nextLine();
		System.out.print("Descrição: ");
		String descricaoProduto = leitor.nextLine();
		
		Produto produto = new Produto(produtoID, nome, descricaoProduto);
		cliente.getProjetos().get(projetoID - 1).setProduto(produto);
		
		System.out.println();
		System.out.println("[ Cadastro dos Requisitos ]");
		System.out.println();
		
		System.out.print("Você deseja cadastrar quantos requisitos? ");
		Integer quantidade = leitor.nextInt();
		leitor.nextLine();
		
		for (int i = 0; i < quantidade; i++) {
			System.out.println();
			System.out.println("[ Cadastro dos Requisitos ]");
			System.out.println();
			
			System.out.print("Descrição: ");
			String descricaoRequisito = leitor.nextLine();
			
			System.out.print("Prioridade(1 Alta)(2 Media)(3 Baixa): ");
			Integer prioridade = leitor.nextInt();
			leitor.nextLine();
			
			Requisito requisito = new Requisito(requisitoID, descricaoRequisito, Prioridade.toEnum(prioridade), produto);
			cliente.getProjetos().get(projetoID - 1).getProduto().getRequisitos().addAll(Arrays.asList(requisito));
			requisitoID++;
		}
		
		produtoID++;
		cadastroDeEquipeETarefas();
	}
	
	// Menu Cadastro de Equipe e Tarefas - Código ?<&H$#
	public static void cadastroDeEquipeETarefas() {
		System.out.println();
		System.out.println("[ Cadastro de Equipe ]");
		System.out.println();
		
		System.out.print("Nome: ");
		String nomeEquipe = leitor.nextLine();
		
		Equipe equipe = new Equipe(equipeID, nomeEquipe);
		clientes.get(cliente.getUsuarioID() - 1).getProjetos().get(projetoID - 1).setEquipe(equipe);
		
		System.out.println();
		System.out.println("[ Cadastro de Funcionario e Tarefa ]");
		System.out.println();
		
		System.out.print("Deseja cadastrar quantos funcionarios? ");
		Integer quantidadeFuncionarios = leitor.nextInt();
		leitor.nextLine();
		
		for (int i = 0; i < quantidadeFuncionarios; i++) {
			System.out.println();
			System.out.println("[ Cadastro de Funcionario ]");
			System.out.println();
			
			System.out.print("Nome: ");
			String nomeFuncionario = leitor.nextLine();
			System.out.print("CPF: ");
			String cpf = leitor.nextLine();
			System.out.print("Cargo: ");
			String cargo = leitor.nextLine();
			System.out.print("Salário: ");
			BigDecimal salario = leitor.nextBigDecimal();
			leitor.nextLine();
			
			System.out.print("Quantidade de Horas: ");
			int qtdeHoras = leitor.nextInt();
			leitor.nextLine();
			System.out.print("Papel(1 Gerente)(2 Colaborador): ");
			int papel = leitor.nextInt();
			leitor.nextLine();
			
			Funcionario funcionario = new Funcionario(usuarioID, nomeFuncionario, cpf, cargo, salario);
			
			System.out.println();
			System.out.println("[ Cadastro de Tarefa ]");
			System.out.println();
			
			System.out.print("Deseja cadastrar quantos tarefas? ");
			Integer quantidadeTarefas = leitor.nextInt();
			leitor.nextLine();
			
			for (int j = 0; j < quantidadeTarefas; j++) {
				System.out.println();
				System.out.println("[ Cadastro de Tarefa ]");
				System.out.println();
				
				System.out.print("Descrição: ");
				String descricao = leitor.nextLine();
				
				try {
					System.out.print("Data de entrega no formato(dd/mm/aaaa): ");
					String dataEntregaString = leitor.nextLine();
					Date dataEntrega = formatadorData.parse(dataEntregaString);
					
					Tarefa tarefa = new Tarefa(tarefaID, descricao, dataEntrega, EstadoTarefa.toEnum(1), funcionario);
					
					funcionario.getTarefas().addAll(Arrays.asList(tarefa));
					
					tarefaID++;
				} catch(Exception e) {
					System.out.println("Formato Incorreto de Data");
				}
			}
			
			Atribuicao atribuicao = new Atribuicao(qtdeHoras, equipe, funcionario, Papel.toEnum(papel));
			
			clientes.get(cliente.getUsuarioID() - 1).getProjetos().get(projetoID - 1).getEquipe().getAtribuicoes().addAll(Arrays.asList(atribuicao));
		}
		
		projetoID++;
		projetos();
	}
	
	// Menu Listar Projetos - Código :+%8$R
	public static void listarProjetos() {
		while(true) {
			System.out.println();
			System.out.println("[ Listagem de Projetos ]");
			System.out.println("1.Voltar ao menu de projetos");
			System.out.println("2.Todos os projetos");
			System.out.println("3.Projetos em andamento");
			System.out.println("4.Projetos concluidos");
			System.out.println("5.Projetos atrasados");
			System.out.println();

			System.out.print("Escolha uma opção: ");
			int opcao = leitor.nextInt();
			leitor.nextLine();
			
			if(opcao == 1) {
				projetos();
			} else if(opcao == 2) {
				exibicaoDeProjetos(2);
			} else if(opcao == 3) {
				exibicaoDeProjetos(3);
			} else if(opcao == 4) {
				exibicaoDeProjetos(4);
			} else if(opcao == 5) {
				exibicaoDeProjetos(5);
			} else {
				System.out.println("opção inválida, tente novamente");
			}	
		}
	}
	
	// Menu Exibicao de Projetos - Código >de1DM
	public static void exibicaoDeProjetos(int modoExibicao) {
		while(true) {
			if(modoExibicao == 2) {
				System.out.println(cliente.exibirTodosProjetos());
			} else if(modoExibicao == 3) {
				System.out.println(cliente.exibirProjetosEmAndamento());
			} else if(modoExibicao == 4) {
				System.out.println(cliente.exibirProjetosConcluidos());
			} else if(modoExibicao == 5) {
				try {
					System.out.println(cliente.exibirProjetosAtrasados());
				} catch (Exception e) {
					System.out.println("Problema ao exibir projetos atrasados");
				}
			}
			
			System.out.println("Selecione um projeto por seu ID: ");
			int ID = leitor.nextInt();
			leitor.nextLine();
			
			try {
				projeto = cliente.getProjetos().get(ID - 1);
				equipe = projeto.getEquipe();
				informacoesDoProjeto();
			} catch(Exception e) {
				System.out.println("ID inválido, insira um valor válido");
			}
		}
	}
	
	// Menu Informações do Projeto - Código YJYF|&
	public static void informacoesDoProjeto() {
		while(true) {
			System.out.println();
			System.out.println("[ Informações do Projeto ]");
			System.out.println("1.Voltar ao menu listagem de projetos");
			System.out.println("2.Tarefas");
			System.out.println("3.Produto e Requisitos");
			System.out.println("4.Equipe");
			System.out.println();

			System.out.print("Escolha uma opção: ");
			int opcao = leitor.nextInt();
			leitor.nextLine();
			
			if(opcao == 1) {
				listarProjetos();
			} else if(opcao == 2) {
				tarefasDoProjeto();
			} else if(opcao == 3) {
				produtoERequisitosDoProjeto();
			} else if(opcao == 4) {
				equipeDoProjeto();
			} else {
				System.out.println("opção inválida, tente novamente");
			}	
		}
	}
	
	// Menu Tarefas do Projeto - Código D!)maL
	public static void tarefasDoProjeto() {
		while(true) {
			System.out.println();
			System.out.println("[ Tarefas do Projeto ]");
			System.out.println("1.Todas as tarefas");
			System.out.println("2.Tarefas concluidas");
			System.out.println("3.Tarefas atrasadas");
			System.out.println("4.Tarefas para entregar ate data");
			System.out.println("5.Tarefas pendentes");
			System.out.println();
		
			System.out.print("Escolha uma opção: ");
			int opcao = leitor.nextInt();
			leitor.nextLine();
			
			if(opcao == 1) {
				System.out.println(projeto.exibirTodasTarefas());
			} else if(opcao == 2) {
				System.out.println(projeto.exibirTarefasConcluidas());
			} else if(opcao == 3) {
				System.out.println(projeto.exibirTarefasAtrasadas());
			} else if(opcao == 4) {
				try {
					System.out.print("Insira a data: ");
					System.out.print("Data de inicio no formato(dd/mm/aaaa): ");
					String dataDesejadaString = leitor.nextLine();
					Date dataDesejada = formatadorData.parse(dataDesejadaString);
					projeto.exibirTarefasParaEntregarAte(dataDesejada);
				} catch(Exception e) {
					System.out.println("Formato Incorreto de Data");
				}
			} else if(opcao == 5) {
				System.out.println(projeto.exibirTarefasPendentes());
			} else {
				System.out.println("opção inválida, tente novamente");
			}
			
			System.out.println("1.Voltar ao menu informações do projeto");
			System.out.println("2.Voltar ao menu principal");
			
			System.out.print("Escolha uma opção: ");
			opcao = leitor.nextInt();
			leitor.nextLine();
			
			if(opcao == 1) {
				informacoesDoProjeto();
			} else if(opcao == 2) {
				menuPrincipal();
			} else {
				System.out.println("opção inválida, tente novamente");
			}
		}
	}
	
	// Menu Produto e Requisitos do Projeto - Código k)Lf(A
	public static void produtoERequisitosDoProjeto() {
		while(true) {
			System.out.println();
			System.out.println("[ Produto do Projeto ]");
			System.out.println();
			
			System.out.println("ID: " + projeto.getProduto().getProdutoID());
			System.out.println("Nome: " + projeto.getProduto().getNome());
			System.out.println("Descrição: " + projeto.getProduto().getDescricao());
			
			System.out.println();
			System.out.println("[ Requisitos do Produto ]");
			System.out.println();
			
			System.out.println("1.Exibir todos os requisitos");
			System.out.println("2.Exibir requisitos por prioridade");
			
			System.out.print("Escolha uma opção: ");
			int opcao = leitor.nextInt();
			leitor.nextLine();
			
			if(opcao == 1) {
				System.out.println(projeto.getProduto().exibirTodosRequisitos());
			} else if(opcao == 2) {
				System.out.print("Qual prioridade(1 Alta)(2 Media)(3 Baixa): ");
				int prioridade = leitor.nextInt();
				System.out.println(projeto.getProduto().exibirRequisitosPorPrioridade(Prioridade.toEnum(prioridade)));
			} else {
				System.out.println("opção inválida, tente novamente");
			}
			
			System.out.println();
			System.out.println("1.Voltar ao menu informações do projeto");
			System.out.println("2.Voltar ao menu principal");
			System.out.println();
		
			System.out.print("Escolha uma opção: ");
			opcao = leitor.nextInt();
			leitor.nextLine();
			
			if(opcao == 1) {
				informacoesDoProjeto();
			} else if(opcao == 2) {
				menuPrincipal();
			} else {
				System.out.println("opção inválida, tente novamente");
			}
		}
	}
	
	// Menu Equipe do Projeto - Código T9a(xJ
	public static void equipeDoProjeto() {
		while(true) {
			System.out.println();
			System.out.println("[ Equipe do Projeto ]");
			System.out.println();
			
			System.out.println("ID: " + equipe.getEquipeID());
			System.out.println("Nome: " + equipe.getNome());
			
			System.out.println();
			System.out.println("[ Lista de Funcionários ]");
			System.out.println();
			
			System.out.println(equipe.exibirFuncionaraios());
			
			System.out.println("Selecione um funcionario por seu ID: ");
			int ID = leitor.nextInt();
			leitor.nextLine();
			
			try {
				for(Atribuicao atribuicao : equipe.getAtribuicoes()) {
					if(atribuicao.getFuncionario().getUsuarioID() == (ID)) {
						funcionario = atribuicao.getFuncionario();
					}
				}
				funcionarioDaEquipe();
			} catch(Exception e) {
				System.out.println("ID inválido, insira um valor válido");
			}
		}	
	}
	
	// Menu Funcionário da Equipe - Código Llc*q[
	public static void funcionarioDaEquipe() {
		while(true) {
			System.out.println();
			System.out.println("[ Funcionario da Equipe ]");
			System.out.println();
			
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("CPF: " + funcionario.getCpf());
			System.out.println("Cargo: " + funcionario.getCargo());
			System.out.println("Salário: " + funcionario.getSalario());
			System.out.println("Tarefas: " + funcionario.getTarefas());
			System.out.println("Atribuicoes: " + funcionario.getAtribuicoes());
			
			System.out.println();
			System.out.println("1.Voltar ao menu informações do projeto");
			System.out.println("2.Voltar ao menu principal");
			System.out.println();
		
			System.out.print("Escolha uma opção: ");
			int opcao = leitor.nextInt();
			leitor.nextLine();
			
			if(opcao == 1) {
				informacoesDoProjeto();
			} else if(opcao == 2) {
				menuPrincipal();
			} else {
				System.out.println("opção inválida, tente novamente");
			}
		}
	}
	
	// Main - Código ^(P6tO
	public static void main(String[] args) {
		Endereco endereco1 = new Endereco(1, "Rua Alberto Alves Cabral", 5748, "Perto do joaozinho", "Santa Monica", "38408-226" , "Uberlândia", "Minas Gerais");
		Cliente cliente1 = new Cliente(1, "Roobson Silva", "069.231.590-08", "roobson@gmail.com", "34 9999-9999");
		cliente1.setEndereco(endereco1);
		clientes.add(cliente1);
		
		Date data = new Date();
		BigDecimal big = new BigDecimal(10);
		
		Projeto projeto1 = new Projeto(1, "Projeto Xiomi", "O melhor celular", data, data, EstadoProjeto.EM_ANDAMENTO, cliente1);
		Produto produto1 = new Produto(1, "produto", "produto");
		Requisito requisito1 = new Requisito(1, "descricao", Prioridade.toEnum(1), produto1);
		projeto1.setProduto(produto1);
		produto1.getRequisitos().addAll(Arrays.asList(requisito1));
		Equipe equipe1 = new Equipe(1, "alfa");
		Funcionario funcionario1 = new Funcionario(1, "robs", "123", "123", big);
		Tarefa tarefa1 = new Tarefa(1, "123", data, EstadoTarefa.toEnum(1), funcionario1);
		funcionario1.getTarefas().addAll(Arrays.asList(tarefa1));
		Atribuicao atribuicao1 = new Atribuicao(123, equipe1, funcionario1, Papel.toEnum(1));
		equipe1.getAtribuicoes().addAll(Arrays.asList(atribuicao1));
		projeto1.setEquipe(equipe1);
		clientes.get(cliente1.getUsuarioID() - 1).getProjetos().addAll(Arrays.asList(projeto1));
		
		System.out.println("----- Gerenciador de Projetos ------");
		menuPrincipal();
	}

}