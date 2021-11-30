package estacionamento.service;

import java.util.List;
import java.util.Scanner;

import estacionamento.model.Pessoas;
import estacionamento.model.Veiculos;
import estacionamento.model.enums.Marcas;
import estacionamento.model.enums.TiposDeVeiculos;
import estacionamento.repositorio.PessoaRepositorio;
import estacionamento.repositorio.VeiculoRepositorio;

public class VeiculoService {

	private Pessoas donoDoCarro;
	private Veiculos veiculo;
	private PessoaService ps = new PessoaService();
	
	Scanner sc = new Scanner(System.in);
	
	public void cadastraVeiculo(VeiculoRepositorio dadosVeiculo, PessoaRepositorio dadosPessoa) {
		System.out.print("Tipo: "
				+ "\n	1  - Carro"
				+ "\n	2  - Moto"
				+ "\n	3  - Onibus"
				+ "\n	4  - Van"
				+ "\nInforme a opção: ");
		int tipo = sc.nextInt();
		System.out.print("Informe a placa do veículo: ");
		String placa = sc.next();
		System.out.print("Marca: "
				+ "\n	1  - Audi"
				+ "\n	2  - BMW"
				+ "\n	3  - Chevrolet"
				+ "\n	4  - Citroen"
				+ "\n	5  - FIAT"
				+ "\n	6  - Ford"
				+ "\n	7  - Hyundai"
				+ "\n	8  - Honda"
				+ "\n	9  - Jaguar"
				+ "\n	10 - Land Rover"
				+ "\n	11 - Peugeot"
				+ "\n	12 - Toyota"
				+ "\n	13 - Volkswagen"
				+ "\n	14 - Volvo"
				+ "\n	15 - Outro"
				+ "\nInforme a opção: ");
		int marca = sc.nextInt();
		String respostaCadastro;
		do {
			System.out.print("O dono tem cadastro no sistema (s/n): ");
			respostaCadastro = sc.next();
		} while(!respostaCadastro.equalsIgnoreCase("s") && !respostaCadastro.equalsIgnoreCase("n"));
			
		if(respostaCadastro.equalsIgnoreCase("n")) {
			System.out.println("\nPreencha dados pessoais do dono:");
			ps.cadastraPessoa(dadosPessoa.getListaPessoasCadastradas());
			donoDoCarro = ps.getPessoa();
			veiculo = new Veiculos(TiposDeVeiculos.procurarOpcao(tipo), Marcas.procurarOpcao(marca), placa.toUpperCase(), donoDoCarro);
			dadosVeiculo.adicionarAoVeiculoAoBandoDeDados(veiculo);
		}
		if(respostaCadastro.equalsIgnoreCase("s")) {
			System.out.print("Informe o nome: ");
			String nome = sc.next();
			ps.consultaPessoa(dadosPessoa.getListaPessoasCadastradas(), nome.toUpperCase());
			donoDoCarro = ps.getPessoa();
			if (donoDoCarro == null) {
				System.out.println("Preencha dados pessoais do dono:");
				ps.cadastraPessoa(dadosPessoa.getListaPessoasCadastradas());
				donoDoCarro = ps.getPessoa();
				veiculo = new Veiculos(TiposDeVeiculos.procurarOpcao(tipo), Marcas.procurarOpcao(marca), placa.toUpperCase(), donoDoCarro);
				dadosVeiculo.adicionarAoVeiculoAoBandoDeDados(veiculo);
				return;
			}
			veiculo = new Veiculos(TiposDeVeiculos.procurarOpcao(tipo), Marcas.procurarOpcao(marca),placa.toUpperCase(), donoDoCarro);
			dadosVeiculo.adicionarAoVeiculoAoBandoDeDados(veiculo);
		}
		System.out.println("\nVeículo cadastrado com sucesso!\n");
	}

	public void consultaVeiculo(List<Veiculos> lista, String placa) {
		for (Veiculos v : lista) {
			if (placa.toUpperCase().equals(v.getPlacaDoVeiculo())) {
				System.out.println("\nVeículo encontrado!");
				veiculo = v;
				System.out.println(v);
				return;
			}
		}
		System.out.println("Veículo não encontrado!\n");
	}
	
	public void editaVeiculo(List<Veiculos> lista, String placaDoVeiculo) {
		for (Veiculos v : lista) {
			if (placaDoVeiculo.toUpperCase().equals(v.getPlacaDoVeiculo())) {	
				System.out.println("\nVeículo encontrado!\n");
				System.out.println(v);
				
				String respostaEditor;
				do {
					System.out.print("\nTem certeza que deseja editar os dados do veículo (s/n): ");
					respostaEditor = sc.nextLine();
				} while(!respostaEditor.equalsIgnoreCase("s") && !respostaEditor.equalsIgnoreCase("n"));
				
				if (respostaEditor.equalsIgnoreCase("s")) {
					System.out.print("Tipo: "
							+ "\n	1  - Carro"
							+ "\n	2  - Moto"
							+ "\n	3  - Onibus"
							+ "\n	4  - Van"
							+ "\nInforme a opção: ");
					int novoTipo = sc.nextInt();
					System.out.print("Nova placa: ");
					String novoPlaca = sc.next();
					System.out.print("Marca: "
							+ "\n	1  - Audi"
							+ "\n	2  - BMW"
							+ "\n	3  - Chevrolet"
							+ "\n	4  - Citroen"
							+ "\n	5  - FIAT"
							+ "\n	6  - Ford"
							+ "\n	7  - Hyundai"
							+ "\n	8  - Honda"
							+ "\n	9  - Jaguar"
							+ "\n	10 - Land Rover"
							+ "\n	11 - Peugeot"
							+ "\n	12 - Toyota"
							+ "\n	13 - Volkswagen"
							+ "\n	14 - Volvo"
							+ "\n	15 - Outro"
							+ "\nInforme a opção: ");
					int novaMarca = sc.nextInt();
					v.setTipo(TiposDeVeiculos.procurarOpcao(novoTipo));
					v.setPlacaDoVeiculo(novoPlaca);
					v.setMarca(Marcas.procurarOpcao(novaMarca));
					String respostaEditorDono;
					do {
						System.out.print("Deseja editar os dados pessoais do dono (s/n): ");
						respostaEditorDono = sc.next();
					} while(!respostaEditorDono.equalsIgnoreCase("s") && !respostaEditorDono.equalsIgnoreCase("n"));
					
					if (respostaEditorDono.equalsIgnoreCase("s")) {
						ps.editaPessoa(v);
						System.out.println("Dados do veículo e do dono editados!");
						return;
					}
					if (respostaEditorDono.equalsIgnoreCase("n")) {
						System.out.println("Dados do veículo editados!");
						return;
					}	
				}
				if (respostaEditor.equalsIgnoreCase("n")) {
					return;
				}	
			}
			System.out.println("Veículo não encontrado!");
		}
	}
	
	public void excluiVeiculo(List<Veiculos> lista, String placaDoVeiculo) {
		for (Veiculos v : lista) {
			if (placaDoVeiculo.toUpperCase().equals(v.getPlacaDoVeiculo())) {
				System.out.println("\nVeículo encontrado!\n");
				System.out.println(v);
				String resposta;
				do {
					System.out.print("\nTem certeza que deseja excluir (s/n): ");
					resposta = sc.nextLine();
				} while(!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n"));
				
				if (resposta.equalsIgnoreCase("s")) {
					System.out.println("Veículo excluido!");
					lista.remove(v);
					return;
				}
				if (resposta.equalsIgnoreCase("n")) {
					return;
				}	
			}
		}
		System.out.println("Veículo não encontrado!\n");
	}
	
	public Veiculos getVeiculo() {
		return veiculo;
	}

	public Pessoas getDonoDoCarro() {
		return donoDoCarro;
	}
}
