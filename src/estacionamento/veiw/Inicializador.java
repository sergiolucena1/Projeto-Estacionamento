package estacionamento.veiw;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import estacionamento.model.Pessoas;
import estacionamento.model.VagasEstacionamento;
import estacionamento.model.Veiculos;
import estacionamento.model.enums.TiposDePessoas;
import estacionamento.model.enums.TiposDeVeiculos;
import estacionamento.repositorio.EstacionamentoRepositorio;
import estacionamento.repositorio.PessoaRepositorio;
import estacionamento.repositorio.VeiculoRepositorio;
import estacionamento.service.EstacionamentoService;
import estacionamento.service.PessoaService;
import estacionamento.service.VeiculoService;

public class Inicializador {

	private PessoaService ps = new PessoaService();
	private VeiculoService vs = new VeiculoService();
	private EstacionamentoService es = new EstacionamentoService();
	Scanner sc = new Scanner(System.in);
	
	public void inicializaPrograma(PessoaRepositorio dadosPessoa, VeiculoRepositorio dadosVeiculo, EstacionamentoRepositorio dadosEstacionamento) {
		System.out.println("\n\n======================================  E S T A C I O N A M E N T O   U N I E S P  ======================================");
		System.out.print("\nSERVIÇOS:\n" 				
				+ "\n- ESTACIONAMENTO:"
				+ "\n	 1 - Adicionar entrada de veículo"
				+ "\n	 2 - Adicionar saída de veículo"
				+ "\n	 3 - Lista de veículos ainda estacionados"
				+ "\n	 4 - Lista por tipo de veículo"  
				+ "\n	 5 - Lista por tipo de pessoa"
				+ "\n	 6 - Lista de todas entradas no estacionamento"
				+ "\n	 7 - Lista de todas saídas do estacionamento\n"				
				+ "\n- VEÍCULOS:" 
				+ "\n	 8 - Cadastrar"
				+ "\n	 9 - Consultar"
				+ "\n	10 - Editar"
				+ "\n	11 - Excluir"
				+ "\n	12 - Lista por tipo de veículo cadastrado"
				+ "\n	13 - Lista de todos veículos cadastrados\n"			
				+ "\n- PESSOAS:" 
				+ "\n	14 - Cadastrar"
				+ "\n	15 - Consultar"
				+ "\n	16 - Editar"
				+ "\n	17 - Excluir"
				+ "\n	18 - Lista por tipo de pessoa cadastrada"
				+ "\n	19 - Lista de todas pessoas cadastradas\n"	 			
				+ "\n- ENCERRAR:" 
				+ "\n	20 - Encerrar programa\n");
		
		List<String> opcoes = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20");
		System.out.print("\nInforme a opção: ");
		String opcao = sc.next();
		if (!opcoes.contains(opcao)) {
			System.out.println("Opção inválida!");
			inicializaPrograma(dadosPessoa, dadosVeiculo, dadosEstacionamento);
		}
		System.out.println("\n=========================================================================================================================");

		switch (opcao) {
		case "1":
			System.out.println("\n\n- ENTRADA DE VEÍCULO:\n");
			System.out.print("Informe a placa do veículo: ");
			String placaEntrada = sc.next();
			es.entradaDeVeiculo(dadosPessoa, dadosVeiculo, dadosEstacionamento, placaEntrada);		
			inicializaPrograma(dadosPessoa, dadosVeiculo, dadosEstacionamento);
		case "2":
			System.out.println("\n\n- SAÍDA DE VEÍCULO:\n");
			System.out.print("Informe a placa do veículo: ");
			String placaSaida = sc.next();
			es.saidaDeVeiculo(dadosPessoa, dadosVeiculo, dadosEstacionamento, placaSaida);
			inicializaPrograma(dadosPessoa, dadosVeiculo, dadosEstacionamento);
		case "3":
			System.out.println("\n\n- LISTA DE VEÍCULOS AINDA ESTACIONADOS:\n");
			System.out.println(dadosEstacionamento.getListaDeVagasEmUso());
			inicializaPrograma(dadosPessoa, dadosVeiculo, dadosEstacionamento);	
		case "4":
			System.out.println("\n\n- LISTA POR TIPO DE VEÍCULO ESTACIONADOS:\n");
			System.out.print("Tipo: "
					+ "\n	1  - Carro"
					+ "\n	2  - Moto"
					+ "\n	3  - Onibus"
					+ "\n	4  - Van"
					+ "\nInforme a opção: ");
			int tipo = sc.nextInt();
			if (dadosEstacionamento.getListaDeEntradasNoEstacionamento().isEmpty()) {
				System.out.println("\nNão entraram veículos desde tipo no estacionamento");
				inicializaPrograma(dadosPessoa, dadosVeiculo, dadosEstacionamento);
			}
			for(VagasEstacionamento v : dadosEstacionamento.getListaDeEntradasNoEstacionamento()) {
				if (v.getVeiculo().getTipo() == TiposDeVeiculos.procurarOpcao(tipo)) {
					System.out.println(v);
				}
			}
			inicializaPrograma(dadosPessoa, dadosVeiculo, dadosEstacionamento);
		case "5":			
			System.out.println("\n\n- LISTA POR TIPO DE PESSOA QUE ENTRARAM NO ESTACIONAMENTO:\n");
			System.out.print("Tipo: "
					+ "\n	1 - Aluno"
					+ "\n	2 - Funcionário"
					+ "\n	3 - Terceirizado"
					+ "\n	4 - Visitante"
					+ "\nInforme a opção: ");	
			int novoTipo = sc.nextInt();
			if (dadosEstacionamento.getListaDeEntradasNoEstacionamento().isEmpty()) {
				System.out.println("\nNão entraram veículos desde tipo no estacionamento");
				inicializaPrograma(dadosPessoa, dadosVeiculo, dadosEstacionamento);
			}
			for(VagasEstacionamento v : dadosEstacionamento.getListaDeEntradasNoEstacionamento()) {
				if (v.getVeiculo().getDono().getTipo() == TiposDePessoas.procurarOpcao(novoTipo)) {
					System.out.println(v);
				}
			}
			inicializaPrograma(dadosPessoa, dadosVeiculo, dadosEstacionamento);
		case "6":			
			System.out.println("\n\n- LISTA DE TODAS ENTRADAS NO ESTACIONAMENTO:\n");
			System.out.println(dadosEstacionamento.getListaDeEntradasNoEstacionamento());
			inicializaPrograma(dadosPessoa, dadosVeiculo, dadosEstacionamento);	
		case "7":			
			System.out.println("\n\n- LISTA DE TODAS SAÍDAS NO ESTACIONAMENTO:\n");
			for(VagasEstacionamento v : dadosEstacionamento.getListaDeEntradasNoEstacionamento()) {
				if(v.getDataHoraSaida() != null) {
					System.out.println(v);
				}
			}
			inicializaPrograma(dadosPessoa, dadosVeiculo, dadosEstacionamento);	
		case "8":
			System.out.println("\n\n- CADASTRO DE VEÍCULO:\n");
			vs.cadastraVeiculo(dadosVeiculo, dadosPessoa);
			inicializaPrograma(dadosPessoa, dadosVeiculo, dadosEstacionamento);
		case "9":
			System.out.println("\n\n- CONSULTA DE VEÍCULO:\n");
			System.out.print("Informe a placa do veículo: ");
			String nomePlaca = sc.next();
			vs.consultaVeiculo(dadosVeiculo.getListaVeiculosCadastrados(), nomePlaca);
			inicializaPrograma(dadosPessoa, dadosVeiculo, dadosEstacionamento);
		case "10":
			System.out.println("\n\n- EDITOR DE VEÍCULO:\n");
			System.out.print("Informe a placa do veículo: ");
			String nomeEditorVeiculo = sc.next();
			vs.editaVeiculo(dadosVeiculo.getListaVeiculosCadastrados(), nomeEditorVeiculo);
			inicializaPrograma(dadosPessoa, dadosVeiculo, dadosEstacionamento);
		case "11":
			System.out.println("\n\n- EXCLUIR VEÍCULO:\n");
			System.out.print("Informe a placa do veículo: ");
			String placaParaExcluir = sc.next();
			vs.excluiVeiculo(dadosVeiculo.getListaVeiculosCadastrados(), placaParaExcluir);
			inicializaPrograma(dadosPessoa, dadosVeiculo, dadosEstacionamento);
		case "12":
			System.out.println("\n\n- LISTA POR TIPO DE VEÍCULO CADASTRADO:\n");
			System.out.print("Tipo: "
					+ "\n	1  - Carro"
					+ "\n	2  - Moto"
					+ "\n	3  - Onibus"
					+ "\n	4  - Van"
					+ "\nInforme a opção: ");
			int tipoVeiculo = sc.nextInt();
			for(Veiculos v : dadosVeiculo.getListaVeiculosCadastrados()) {
				if (v.getTipo() == TiposDeVeiculos.procurarOpcao(tipoVeiculo)) {
					System.out.println(v);
				}
			}
			inicializaPrograma(dadosPessoa, dadosVeiculo, dadosEstacionamento);	
		case "13":
			System.out.println("\n\n- LISTA DE TODOS VEÍCULOS CADASTRADOS:\n");
			System.out.println(dadosVeiculo.getListaVeiculosCadastrados());
			inicializaPrograma(dadosPessoa, dadosVeiculo, dadosEstacionamento);	
		case "14":
			System.out.println("\n\n- CADASTRO DE PESSOA:\n");
			ps.cadastraPessoa(dadosPessoa.getListaPessoasCadastradas());
			System.out.println("\nPessoa cadastrada com sucesso!\n");
			inicializaPrograma(dadosPessoa, dadosVeiculo, dadosEstacionamento);
		case "15":
			System.out.println("\n\n- CONSULTA DE PESSOA:\n");
			System.out.print("Informe o nome: ");
			String nomeConsulta = sc.next();
			ps.consultaPessoa(dadosPessoa.getListaPessoasCadastradas(), nomeConsulta);
			inicializaPrograma(dadosPessoa, dadosVeiculo, dadosEstacionamento);
		case "16":
			System.out.println("\n\n- EDITOR DE PESSOA:\n");
			System.out.print("Informe o nome: ");
			String nomeEditor = sc.next();
			ps.editaPessoa(dadosPessoa.getListaPessoasCadastradas(), nomeEditor);
			inicializaPrograma(dadosPessoa, dadosVeiculo, dadosEstacionamento);
		case "17":
			System.out.println("\n\n- EXCLUIR PESSOA:\n");
			System.out.print("Informe o nome: ");
			String nomeExclusor = sc.next();
			ps.excluiPessoa(dadosPessoa.getListaPessoasCadastradas(), nomeExclusor);
			inicializaPrograma(dadosPessoa, dadosVeiculo, dadosEstacionamento);
		case "18":		
			System.out.println("\n\n- LISTA POR TIPO DE PESSOA CADASTRADA:\n");
			System.out.print("Tipo: "
					+ "\n	1 - Aluno"
					+ "\n	2 - Funcionário"
					+ "\n	3 - Terceirizado"
					+ "\n	4 - Visitante"
					+ "\nInforme a opção: ");	
			int novoTipoP = sc.nextInt();
			for(Pessoas p : dadosPessoa.getListaPessoasCadastradas()) {
				if (p.getTipo() == TiposDePessoas.procurarOpcao(novoTipoP)) {
					System.out.println(p);
				}
			}
			inicializaPrograma(dadosPessoa, dadosVeiculo, dadosEstacionamento);
		case "19":
			System.out.println("\n\n- LISTA DE TODAS PESSOAS CADASTRADOS:\n");
			System.out.println(dadosPessoa.getListaPessoasCadastradas());
			inicializaPrograma(dadosPessoa, dadosVeiculo, dadosEstacionamento);	
		case "20":
			System.out.println("\n\nSistema encerrado!");
			break;
		}
	}
}
