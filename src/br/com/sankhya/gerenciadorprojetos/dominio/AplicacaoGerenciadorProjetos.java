package br.com.sankhya.gerenciadorprojetos.dominio;

public class AplicacaoGerenciadorProjetos {

	public static void main(String[] args) {
		Endereco endereco = new Endereco(1, "rua", 1010, "Proximo a uma casa", "Santa Monica", "38408-226", "Uberlândia", "MG");
		Cliente cliente = new Cliente(2, "João", "226.468.060-19", "joao@gmail.com", "(34)99999-9999");
		
		endereco.setCliente(cliente);
		cliente.setEndereco(endereco);
		
		System.out.println(endereco.toString());
		System.out.println(cliente.toString());
	}

}
