/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 19/02/2019
Objetivo sucinto da classe: Gerencia os dados e os menus da aplica��o
Escopo do projeto: https://docs.google.com/document/d/1Hskfyyg0FAgsRGs5d1hBUyV5UH1YGbXMyQM99SFdUWk/edit?usp=sharing
Sum�rio:
	Main - C�digo ^(P6tO
	Menu Principal - C�digo wbo$Lp
 	Menu Cadastrar Cliente - C�digo 5tg:h&
 	Menu Listar Clientes - C�digo 2d:U5!
 	Menu Detalhes do Cliente - C�digo QA)DWd
 	Menu Dados Pessoais - C�digo dtzsP+
 	Menu Projetos - C�digo !E.U^x
 	Menu Cadastro de Projeto - C�digo Lq>?Ie
	Menu Cadastro do Produto e Requisitos - C�digo duxkX0
	Menu Cadastro de Equipe e Tarefas - C�digo ?<&H$#
	Menu Listar Projetos - C�digo :+%8$R
	Menu Exibicao de Projetos - C�digo >de1DM
	Menu Informa��es do Projeto - C�digo YJYF|&
	Menu Tarefas do Projeto - C�digo D!)maL
	Menu Produto e Requisitos do Projeto - C�digo k)Lf(A
	Menu Equipe do Projeto - C�digo T9a(xJ
	Menu Funcion�rio do Projeto - C�digo Llc*q[
*/
package br.com.sankhya.gerenciadorprojetos.dominio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.sankhya.gerenciadorprojetos.enums.EstadoProjeto;

public class AplicacaoGerenciadorProjetos {
	public static List<Cliente> clientes = new ArrayList<>();     
	public static Cliente cliente;
	public static Projeto projeto;
	public static Scanner leitor = new Scanner(System.in);
	public static Integer usuarioID = 1;
	public static Integer enderecoID = 1;
	public static Integer projetoID = 1;
	public static SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy"); 
	
	// Menu Principal - C�digo wbo$Lp
	public static void menuPrincipal() {
		while(true) {
			System.out.println();
			System.out.println("[ Menu Principal ]");
			System.out.println("1.Cadastrar Cliente");
			if(clientes.size() >= 1) {
				System.out.println("2.Listar Clientes");
			}
			
			System.out.println();
			System.out.print("Escolha uma op��o: ");
			int opcao = leitor.nextInt();
			leitor.nextLine();
			
			if(opcao == 1) {
				cadastrarCliente();
			} else if(opcao == 2 && clientes.size() >= 1) {
				listarClientes();
			}  else {
				System.out.println("op��o inv�lida, tente novamente");
			}
		}
	}
	
	// Menu Cadastrar Cliente - C�digo 5tg:h&
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
			System.out.print("Dados da Resid�ncia");
			System.out.println();
			System.out.println();
			
			System.out.print("Logradouro(Rua): ");
			String logradouro = leitor.nextLine();
			System.out.print("N�mero: ");
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
	
	// Menu Listar Clientes - C�digo 2d:U5!
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
				System.out.println("ID inv�lido, insira um valor v�lido");
			}
		}
	}
	
	// Menu Detalhes do Cliente - C�digo QA)DWd
	public static void detalhesDoCliente() {
		while(true) {
			System.out.println();
			System.out.println("[ Detalhes do Cliente ]");
			System.out.println("1.Voltar ao menu principal");
			System.out.println("2.Dados pessoais");
			System.out.println("3.Projetos do cliente");
			System.out.println();
		
			System.out.print("Escolha uma op��o: ");
			int opcao = leitor.nextInt();
			leitor.nextLine();
			
			if(opcao == 1) {
				menuPrincipal();
			} else if(opcao == 2) {
				dadosPessoais();
			} else if(opcao == 3) {
				projetos();
			}  else {
				System.out.println("op��o inv�lida, tente novamente");
			}
		}
	}
	
	// Menu Dados Pessoais - C�digo dtzsP+
	// Incompleto
	public static void dadosPessoais() {
		System.out.println();
		System.out.println("[ Dados Pessoais ]");
		System.out.println();
		
		System.out.println("Nome: " + cliente.getNome());
		System.out.println("CPF: " + cliente.getCpf());
		System.out.println("E-mail: " + cliente.getEmail());
		System.out.println("Telefone: " + cliente.getTelefone());
		
		System.out.println();
		System.out.println("[ Dados da Resid�ncia ]");
		System.out.println();
		
		System.out.println("Logradouro(Rua): " + cliente.getEndereco().getLogradouro());
		System.out.println("N�mero: " + cliente.getEndereco().getNumero());
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
		
			System.out.print("Escolha uma op��o: ");
			int opcao = leitor.nextInt();
			leitor.nextLine();
			
			if(opcao == 1) {
				detalhesDoCliente();
			} else if(opcao == 2) {
				menuPrincipal();
			} else {
				System.out.println("op��o inv�lida, tente novamente");
			}
		}
	}
	
	// Menu Projetos - C�digo !E.U^x
	// Incompleto
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
			
			System.out.print("Escolha uma op��o: ");
			int opcao = leitor.nextInt();
			leitor.nextLine();
			
			if(opcao == 1) {
				detalhesDoCliente();
			} else if(opcao == 2) {
				cadastroDeProjeto();
			} else if(opcao == 3 && cliente.getProjetos().size() > 0) {
				listarProjetos();
			} else {
				System.out.println("op��o inv�lida, tente novamente");
			}
		}
	}
	
	// Menu Cadastro de Projeto - C�digo Lq>?Ie
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
				
				Projeto projeto = new Projeto(projetoID, nome, objetivoInteligente, dataInicio, dataFim , EstadoProjeto.toEnum(1), cliente);
				cliente.getProjetos().addAll(Arrays.asList(projeto));
				cadastroDoProdutoERequisitos();
			} catch(Exception e) {
				System.out.println("Formato Incorreto de Data");
			}
		}
	}
	
	// Menu Cadastro do Produto e Requisitos - C�digo duxkX0
	// Incompleto
	public static void cadastroDoProdutoERequisitos() {
		System.out.println();
		System.out.println("[ Cadastro do Produto ]");
		System.out.println();
		// Algo
		System.out.println();
		System.out.println("[ Cadastro dos Requisitos ]");
		System.out.println();
		// Algo
	}
	
	// Menu Cadastro de Equipe e Tarefas - C�digo ?<&H$#
	// Incompleto
	public static void cadastroDeEquipeETarefas() {
		System.out.println();
		System.out.println("[ Cadastro de Equipe e Tarefas ]");
		System.out.println();
		// Algo
	}
	
	// Menu Listar Projetos - C�digo :+%8$R
	// Incompleto
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

			System.out.print("Escolha uma op��o: ");
			int opcao = leitor.nextInt();
			leitor.nextLine();
			
			if(opcao == 1) {
				projetos();
			} else if(opcao == 2) {
				exibicaoDeProjetos(1);
			} else if(opcao == 3) {
				exibicaoDeProjetos(2);
			} else if(opcao == 4) {
				exibicaoDeProjetos(3);
			} else if(opcao == 5) {
				exibicaoDeProjetos(4);
			} else {
				System.out.println("op��o inv�lida, tente novamente");
			}	
		}
	}
	
	// Menu Exibicao de Projetos - C�digo >de1DM
	// Incompleto
	public static void exibicaoDeProjetos(int modoExibicao) {
		// Algo
	}
	
	// Menu Informa��es do Projeto - C�digo YJYF|&
	// Incompleto
	public static void informacoesDoProjeto() {
		while(true) {
			System.out.println();
			System.out.println("[ Informa��es do Projeto ]");
			System.out.println("1.Voltar ao menu listagem de projetos");
			System.out.println("2.Tarefas");
			System.out.println("3.Produto e Requisitos");
			System.out.println("4.Equipe");
			System.out.println();

			System.out.print("Escolha uma op��o: ");
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
				System.out.println("op��o inv�lida, tente novamente");
			}	
		}
	}
	
	// Menu Tarefas do Projeto - C�digo D!)maL
	// Incompleto
	public static void tarefasDoProjeto() {
		System.out.println();
		System.out.println("[ Tarefas do Projeto ]");
		System.out.println();
		
		while(true) {
			System.out.println();
			System.out.println("1.Voltar ao menu informa��es do projeto");
			System.out.println("2.Voltar ao menu principal");
			System.out.println();
		
			System.out.print("Escolha uma op��o: ");
			int opcao = leitor.nextInt();
			leitor.nextLine();
			
			if(opcao == 1) {
				informacoesDoProjeto();
			} else if(opcao == 2) {
				menuPrincipal();
			} else {
				System.out.println("op��o inv�lida, tente novamente");
			}
		}
	}
	
	// Menu Produto e Requisitos do Projeto - C�digo k)Lf(A
	// Incompleto
	public static void produtoERequisitosDoProjeto() {
		System.out.println();
		System.out.println("[ Produto do Projeto ]");
		System.out.println();
		
		// Algo
		
		System.out.println();
		System.out.println("[ Requisitos do Produto ]");
		System.out.println();
		
		// Algo
		
		while(true) {
			System.out.println();
			System.out.println("1.Voltar ao menu informa��es do projeto");
			System.out.println("2.Voltar ao menu principal");
			System.out.println();
		
			System.out.print("Escolha uma op��o: ");
			int opcao = leitor.nextInt();
			leitor.nextLine();
			
			if(opcao == 1) {
				informacoesDoProjeto();
			} else if(opcao == 2) {
				menuPrincipal();
			} else {
				System.out.println("op��o inv�lida, tente novamente");
			}
		}
	}
	
	// Menu Equipe do Projeto - C�digo T9a(xJ
	// Incompleto
	public static void equipeDoProjeto() {
		while(true) {
			System.out.println();
			System.out.println("[ Equipe do Projeto ]");
			System.out.println();
			
			// Algo
		}	
	}
	
	// Menu Funcion�rio da Equipe - C�digo Llc*q[
	// Incompleto
	public static void funcionarioDaEquipe() {
		System.out.println();
		System.out.println("[ Funcionario da Equipe ]");
		System.out.println();
		// Algo
	}
	
	// Main - C�digo ^(P6tO
	public static void main(String[] args) {
		Endereco endereco1 = new Endereco(1, "Rua Alberto Alves Cabral", 5748, "Perto do joaozinho", "Santa Monica", "38408-226" , "Uberl�ndia", "Minas Gerais");
		Cliente cliente1 = new Cliente(1, "Roobson Silva", "069.231.590-08", "roobson@gmail.com", "34 9999-9999");
		cliente1.setEndereco(endereco1);
		clientes.add(cliente1);
		
		System.out.println("----- Gerenciador de Projetos ------");
		menuPrincipal();
	}

}