package br.com.sankhya.gerenciadorprojetos.dominio;

public class AplicacaoGerenciadorProjetos {

	public static void main(String[] args) {
		Usuario usuario = new Usuario(1, "Clovis", "327.458.063-12");
		System.out.println(usuario.toString());
		
		Cliente cliente = new Cliente(2, "Jo�o", "226.468.060-19", "joao@gmail.com", "(34)99999-9999");
		System.out.println(cliente.toString());
	}

}
