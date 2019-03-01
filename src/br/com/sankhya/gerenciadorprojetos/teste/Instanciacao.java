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

		//Instanciacao e formatacao de datas
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		Date dataHoje = formatador.parse(formatador.format(new Date()));
		Date dataDoisDiasAtras = formatador.parse(formatador.format(new Date(dataHoje.getTime() - (1728 * 100000))));
		Date dataQuatroDiasAtras = formatador
				.parse(formatador.format(new Date(dataHoje.getTime() - (1728 * 100000) * 2)));
		Date dataDoisDiasFrente = formatador.parse(formatador.format(new Date(dataHoje.getTime() + (1728 * 100000))));

		//Fluxo Cadastro de Cliente 
		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente1 = new Cliente(21, "Felispe Calipto", "328486528-94", "elCalipto@gmail.com", "(34) 9898-3434");
		Cliente cliente2 = new Cliente(31, "Zeca Estarvolds", "684987881-54", "estarvolds@gmail.com", "(16) 9768-9627");
		Cliente cliente3 = new Cliente(41, "Phillipi Kabrito", "465981567-84", "elCalipto@gmail.com", "(11) 8814-1836");
		Cliente cliente4 = new Cliente(51, "Ripa na Xulipa", "132898471-96", "elCalipto@gmail.com", "(58) 9640-0071");
		Cliente cliente5 = new Cliente(61, "Jose Antonio", "021545486-36", "kiboa@gmail.com", "(34) 8841-6550");
		clientes.addAll(Arrays.asList(cliente1, cliente2, cliente3, cliente4, cliente5));
		
		//Cria e seta enderecos
		Endereco endereco1 = new Endereco(26, "Esse aqui eu sei nao", 666, "Do lado da zona", "Lindice", "38407615",
				"Ubersandia", "Minas Diversas"); 
		cliente1.setEndereco(endereco1);
		Endereco endereco2 = new Endereco(63, "O mano que corta cabelo", 578, "Do lado da zona", "Dona Zumira",
				"38969454 ", "Belo Horisol", "Rio de Fevereiro");
		cliente2.setEndereco(endereco2);
		Endereco endereco3 = new Endereco(54, "Super-mercado valor", 330, "Do lado da zona", "Bairro Brasil",
				"38384864", "Pedrinopolio", "Mato Grosso do Leste");
		cliente3.setEndereco(endereco3);
		Endereco endereco4 = new Endereco(97, "O banco da esquina", 237, "Praca do nao sei", "Luizote de Freitas",
				"38404658", "Uberraba", "Sao Chico");
		cliente4.setEndereco(endereco4);
		Endereco endereco5 = new Endereco(81, "Aonde todo mundo era bem vindo", 140, "Em frente o ponto",
				"Segismundo Pereira", "38408306", "Ubercanja", "STS");
		cliente5.setEndereco(endereco5);
		
		//Fluxo Listar Clientes
		for(Cliente cliente : clientes) {
			System.out.println(cliente.getUsuarioID() + " " + cliente.getNome());
		}
				
		//Fluxo Detalhes de Clientes - Dados pessoais
		System.out.println(cliente1);
		System.out.println(cliente2);
		System.out.println(cliente3);
		System.out.println(cliente4);
		System.out.println(cliente5);
		
		//Fluxo Detalhes de Clientes - Projetos do cliente 
		//Fluxo Menu de Projetos - Listar projetos
		//Fluxo Listar Projetos - Todos os projetos
		//System.out.println(cliente1.exibirTodosProjetos());
		
		
		/*Funcionario funcionario = new Funcionario(1, "Ana", "100605106-74", "Analista", new BigDecimal("1.5"));
		Funcionario funcionario2 = new Funcionario(2, "Clara", "100995106-74", "Analista 1", new BigDecimal("1.8"));
		Funcionario funcionario3 = new Funcionario(3, "Francisc", "1002345506-74", "Analista de treino",
				new BigDecimal("8.8"));
		Funcionario funcionario4 = new Funcionario(4, "Indente", "100995106-87", "Analista 4", new BigDecimal("2.8"));
		Funcionario funcionario5 = new Funcionario(5, "Escura", "100995106-987", "Analista 5", new BigDecimal("3.8"));

		Tarefa taf1 = new Tarefa(12, "Tudo gado", dataDoisDiasAtras, EstadoTarefa.ATRASADA, funcionario);
		Tarefa taf2 = new Tarefa(22, "Tudo boi", dataDoisDiasAtras, EstadoTarefa.PENDENTE, funcionario);
		Tarefa taf3 = new Tarefa(32, "Tudo vaca", dataDoisDiasAtras, EstadoTarefa.CONCLUIDA, funcionario2);
		Tarefa taf4 = new Tarefa(42, "Tudo rere", dataDoisDiasAtras, EstadoTarefa.ATRASADA, funcionario2);
		Tarefa taf5 = new Tarefa(52, "Tudo do pasto", dataDoisDiasAtras, EstadoTarefa.PENDENTE, funcionario2);

		funcionario.getTarefas().addAll(Arrays.asList(taf1, taf2, taf5));
		funcionario2.getTarefas().addAll(Arrays.asList(taf3, taf4));

		Equipe equipe = new Equipe(1, "Equipe aguia");

		Atribuicao atribuicao1 = new Atribuicao(5, equipe, funcionario, Papel.COLABORADOR);
		Atribuicao atribuicao2 = new Atribuicao(6, equipe, funcionario2, Papel.COLABORADOR);
		Atribuicao atribuicao3 = new Atribuicao(8, equipe, funcionario3, Papel.GERENTE);
		Atribuicao atribuicao4 = new Atribuicao(5, equipe, funcionario4, Papel.COLABORADOR);
		Atribuicao atribuicao5 = new Atribuicao(3, equipe, funcionario5, Papel.COLABORADOR);

		funcionario.getAtribuicoes().addAll(Arrays.asList(atribuicao1));
		funcionario2.getAtribuicoes().addAll(Arrays.asList(atribuicao2));
		funcionario3.getAtribuicoes().addAll(Arrays.asList(atribuicao3));
		funcionario4.getAtribuicoes().addAll(Arrays.asList(atribuicao4));
		funcionario5.getAtribuicoes().addAll(Arrays.asList(atribuicao5));

		equipe.getAtribuicoes().addAll(Arrays.asList(atribuicao1, atribuicao2, atribuicao3, atribuicao4, atribuicao5));

		Endereco endereco1 = new Endereco(26, "Esse aqui eu sei nao", 666, "Do lado da zona", "Lindice", "38407615",
				"Ubersandia", "Minas Diversas");
		Endereco endereco2 = new Endereco(63, "O mano que corta cabelo", 578, "Do lado da zona", "Dona Zumira",
				"38969454 ", "Belo Horisol", "Rio de Fevereiro");
		Endereco endereco3 = new Endereco(54, "Super-mercado valor", 330, "Do lado da zona", "Bairro Brasil",
				"38384864", "Pedrinopolio", "Mato Grosso do Leste");
		Endereco endereco4 = new Endereco(97, "O banco da esquina", 237, "Praca do nao sei", "Luizote de Freitas",
				"38404658", "Uberraba", "Sao Chico");
		Endereco endereco5 = new Endereco(81, "Aonde todo mundo era bem vindo", 140, "Em frente o ponto",
				"Segismundo Pereira", "38408306", "Ubercanja", "STS");

		Projeto projeto1 = new Projeto(23, "Market Atzap", "Criar um chat conversa para o mercado de trabalho",
				dataDoisDiasAtras, dataHoje, EstadoProjeto.CONCLUIDO, cliente1);
		Projeto projeto2 = new Projeto(33, "Manager Liber", "Desenolver uma replicação de uma biblioteca",
				dataQuatroDiasAtras, dataDoisDiasAtras, EstadoProjeto.EM_ANDAMENTO, cliente2);
		Projeto projeto3 = new Projeto(23, "Calculate Back-ENd", "Software de uma calculadora feita com Java",
				dataDoisDiasAtras, dataHoje, EstadoProjeto.CONCLUIDO, cliente3);
		Projeto projeto4 = new Projeto(23, "Fortnite Lite", "Otimizar o game - Fortnite", dataDoisDiasAtras, dataHoje,
				EstadoProjeto.EM_ANDAMENTO, cliente4);
		Projeto projeto5 = new Projeto(23, "Grabs Hero", "Buscar picos para dar uma stritada", dataDoisDiasAtras,
				dataHoje, EstadoProjeto.CONCLUIDO, cliente5);

		Produto produto1 = new Produto(24, "Este e um produto", "Nao sabemos o que ele faz");

		Requisito requisito1 = new Requisito(45, "Precisamos que ele faça o que voce nao faz", Prioridade.MEDIA,
				produto1);
		Requisito requisito2 = new Requisito(46, "Necessita-se de uma aplicaçao inteligente", Prioridade.ALTA,
				produto1);
		Requisito requisito3 = new Requisito(47, "Se um mais um for dois ele precisa ser 3", Prioridade.BAIXA,
				produto1);

		System.out.println(atribuicao1.calcularPrecoTotal());
		System.out.println(atribuicao2.calcularPrecoTotal());
		System.out.println(atribuicao3.calcularPrecoTotal());
		System.out.println(atribuicao4.calcularPrecoTotal());
		System.out.println(atribuicao5.calcularPrecoTotal());

		System.out.println(equipe.exibirFuncionariosTarefasAtrasadas());
		System.out.println(requisito1);*/
		
		//System.out.println();
	}
}