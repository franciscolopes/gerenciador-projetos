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
 	Menu de Projetos - Código !E.U^x
*/
package br.com.sankhya.gerenciadorprojetos.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AplicacaoGerenciadorProjetos {
	public static List<Cliente> clientes = new ArrayList<>();
	public static ArrayList<ArrayList<Projeto>> projetos = new ArrayList<ArrayList<Projeto>>();
	public static ArrayList<Projeto> inner = new ArrayList<Projeto>();        
	public static Cliente cliente;
	public static Projeto projeto;
	public static Scanner leitor = new Scanner(System.in);
	public static Integer usuarioID = 1;
	public static Integer enderecoID = 1;
	
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
		cliente = clientes.get(ID - 1);
		detalhesDoCliente();
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
				menuDeProjetos();
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
	
	// Menu de Projetos - Código !E.U^x
	public static void menuDeProjetos() {
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
			// Algo
		} else if(opcao == 3 && cliente.getProjetos().size() > 0) {
			// Algo
		} else {
			System.out.println("opção inválida, tente novamente");
		}
	}
	
	// Main - Código ^(P6tO
	public static void main(String[] args) {
		Endereco endereco1 = new Endereco(1, "Rua Alberto Alves Cabral", 5748, "Perto do joaozinho", "Santa Monica", "38408-226" , "Uberlândia", "Minas Gerais");
		Cliente cliente1 = new Cliente(1, "Roobson Silva", "069.231.590-08", "roobson@gmail.com", "34 9999-9999");
		cliente1.setEndereco(endereco1);
		clientes.add(cliente1);
		
		System.out.println("----- Gerenciador de Projetos ------");
		menuPrincipal();
	}

}