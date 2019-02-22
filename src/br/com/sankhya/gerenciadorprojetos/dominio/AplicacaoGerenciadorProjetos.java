package br.com.sankhya.gerenciadorprojetos.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AplicacaoGerenciadorProjetos {
	public static List<Cliente> clientes = new ArrayList<>();
	public static Scanner leitor = new Scanner(System.in);
	
	public static void MenuPrincipal() {
		while(true) {
			System.out.println();
			System.out.println("[ Menu Principal ]");
			System.out.println("1.Cadastrar Cliente");
			if(clientes.size() >= 1) {
				System.out.println("2.Listar Clientes");
			}
			
			System.out.print("\nEscolha uma opção: ");
			int opcao = leitor.nextInt();
			
			if(opcao == 1) {
				// Algo
			} else if(opcao == 2) {
				// Algo
			}  else {
				System.out.println("opção inválida, tente novamente");
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("----- Gerenciador de Projetos ------");
		MenuPrincipal();
	}

}