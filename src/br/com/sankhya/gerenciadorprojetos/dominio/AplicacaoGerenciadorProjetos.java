package br.com.sankhya.gerenciadorprojetos.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AplicacaoGerenciadorProjetos {
	public static List<Cliente> clientes = new ArrayList<>(); 
	public static Scanner leitor = new Scanner(System.in);
	public static Integer usuarioID = 1;
	public static Integer enderecoID = 1;
	
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
			} else if(opcao == 2) {
				listarClientes();
			}  else {
				System.out.println("opção inválida, tente novamente");
			}
		}
	}
	
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
	
	public static void listarClientes() {
		System.out.println();
		System.out.println("[ Lista de Clientes ]");
		System.out.println();
		
		for(Cliente cliente : clientes) {
			System.out.println(cliente.getUsuarioID() + " " + cliente.getNome());
		}
		
		System.out.println();
		System.out.print("Selecione um cliente por seu ID: ");
		leitor.nextInt();
	}
	
	public static void main(String[] args) {
		Endereco endereco1 = new Endereco(1, "Rua Alberto Alves Cabral", 5748, "Perto do joaozinho", "Santa Monica", "38408-226" , "Uberlândia", "Minas Gerais");
		Cliente cliente1 = new Cliente(1, "Roobson Silva", "069.231.590-08", "roobson@gmail.com", "34 9999-9999");
		cliente1.setEndereco(endereco1);
		clientes.add(cliente1);
		
		System.out.println("----- Gerenciador de Projetos ------");
		menuPrincipal();
	}

}