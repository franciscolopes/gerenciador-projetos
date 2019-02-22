package br.com.sankhya.gerenciadorprojetos.dominio;

import java.util.Arrays;
import java.util.Date;
import br.com.sankhya.gerenciadorprojetos.enums.EstadoProjeto;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AplicacaoGerenciadorProjetos {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		String dateString = format.format(new Date());
		Date date = format.parse("2009-12-31");   
		
		Cliente cliente = new Cliente(1, "joao", "223-332", "joao.com", "991100");
		Projeto projeto1 = new Projeto(1, "celular", "fazer celular", date, date, EstadoProjeto.toEnum(2), cliente);
		Projeto projeto2 = new Projeto(1, "celular", "fazer celular", date, date, EstadoProjeto.toEnum(2), cliente);
		
		cliente.getProjetos().addAll(Arrays.asList(projeto1, projeto2));
		
		System.out.println(cliente);
		System.out.println(cliente.getProjetos());
		System.out.println(projeto1);
	}

}
