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
				// Algo
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
			
			Endereco endereco = new Endereco(numero, logradouro, numero, complemento, bairro, cep, cidade, estado);
			Cliente cliente = new Cliente(numero, nome, cpf, email, telefone);
			cliente.setEndereco(endereco);
			clientes.add(cliente);
			
			menuPrincipal();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("----- Gerenciador de Projetos ------");
		menuPrincipal();
	}

}