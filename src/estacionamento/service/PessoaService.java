package estacionamento.service;

import java.util.List;
import java.util.Scanner;

import estacionamento.model.Alunos;
import estacionamento.model.Funcionarios;
import estacionamento.model.Pessoas;
import estacionamento.model.Terceirizados;
import estacionamento.model.Veiculos;
import estacionamento.model.Visitantes;
import estacionamento.model.enums.Cargos;
import estacionamento.model.enums.Cursos;
import estacionamento.model.enums.MotivosDaVisita;
import estacionamento.model.enums.TiposDePessoas;
import estacionamento.model.enums.TiposDeServicos;

public class PessoaService {

	private Pessoas pessoa;
	Scanner sc = new Scanner(System.in);
	
	public void cadastraPessoa(List<Pessoas> listaPessoasCadastradas) {	
		System.out.print("Informe o nome: ");
		String nome = sc.next();
		System.out.print("Informe o CPF: ");
		String cpf = sc.next();
		System.out.print("Tipo: "
				+ "\n	1  - Aluno"
				+ "\n	2  - Funcionário"
				+ "\n	3  - Terceirizado"
				+ "\n	4  - Visitante"
				+ "\nInforme a opção: ");
		int tipo = sc.nextInt();
		switch(tipo) {
		
		case 1:
			System.out.print("Informe a matrícula: ");
			Integer matricula = sc.nextInt();
			System.out.print("Curso: "
					+ "\n	1  - Administração"
					+ "\n	2  - Arquitetura e Urbanismo"
					+ "\n	3  - Ciências Contábeis"
					+ "\n	4  - Direito"
					+ "\n	5  - Educação Física"
					+ "\n	6  - Enfermagem"
					+ "\n	7  - Engenharia Civil"
					+ "\n	8  - Farmácia"
					+ "\n	9  - Fisioterapia"
					+ "\n	10 - Nutrição"
					+ "\n	11 - Odontologia"
					+ "\n	12 - Psicologia"
					+ "\n	13 - Sistemas de Informação"
					+ "\n	14 - Sistemas para Internet"
					+ "\nInforme a opção: ");
			int curso = sc.nextInt();
			pessoa = new Alunos(nome.toUpperCase(), cpf, TiposDePessoas.procurarOpcao(tipo), matricula, Cursos.procurarOpcao(curso));
			listaPessoasCadastradas.add(pessoa);			
			break;
		
		case 2:
			System.out.print("Informe o registro de trabalho: ");
			Integer registro = sc.nextInt();
			System.out.print("Cargo: "
					+ "\n	1 - Serviços gerais"
					+ "\n	2 - Segurança"
					+ "\n	3 - Secretária"
					+ "\n	4 - Bibliotecária"
					+ "\n	5 - Telemarketing"
					+ "\n	6 - Técnico de informática"
					+ "\n	7 - RH"
					+ "\n	8 - Tesoreiro"
					+ "\n	9 - Coordenador"
					+ "\n	10 - Professor"
					+ "\n	11 - Gerente"
					+ "\n	12 - Reitor"
					+ "\nInforme a opção: ");
			int cargo = sc.nextInt();
			pessoa = new Funcionarios(nome.toUpperCase(), cpf, TiposDePessoas.procurarOpcao(tipo), registro, Cargos.procurarOpcao(cargo));
			listaPessoasCadastradas.add(pessoa);
			break;
		
		case 3:
			System.out.print("Informe o nome da empresa: ");
			String nomeEmpresa = sc.next();
			System.out.print("Tipo de serviço: "
					+ "\n	1 - Eletricista"
					+ "\n	2 - Entregador"
					+ "\n	3 - Encanador"
					+ "\n	4 - Jardineiro"
					+ "\n	5 - Motorista"
					+ "\n	6 - Pedreiro"
					+ "\n	7 - Pintor"
					+ "\nInforme a opção: ");
			int tipoServico = sc.nextInt();
			pessoa = new Terceirizados(nome.toUpperCase(), cpf, TiposDePessoas.procurarOpcao(tipo), nomeEmpresa, TiposDeServicos.procurarOpcao(tipoServico));
			listaPessoasCadastradas.add(pessoa);
			break;
		
		case 4:
			System.out.print("Informe o número do telefone: ");
			Integer numeroTelefone = sc.nextInt();
			System.out.print("Motivo da visita: "
					+ "\n	1 - Conhecer instalações"
					+ "\n	2 - Obter informações"
					+ "\n	3 - Fazer matrícula"
					+ "\n	4 - Atendimento da clínica escola"
					+ "\n	5 - Falar com funcionário"
					+ "\n	6 - Falar com aluno"
					+ "\n	7 - Outros"
					+ "\nInforme a opção: ");
			int motivo = sc.nextInt();
			listaPessoasCadastradas.add(new Visitantes(nome.toUpperCase(), cpf, TiposDePessoas.procurarOpcao(tipo), numeroTelefone, MotivosDaVisita.procurarOpcao(motivo)));
			break;
		default:
			sc.close();
		}		
	}

	public void consultaPessoa(List<Pessoas> lista, String nome) {
		for (Pessoas p : lista) {
			if (nome.toUpperCase().equals(p.getNome())) {
				System.out.println("\nPessoa encontrada!");
				pessoa = p;
				System.out.println(p);
				return;
			}
		}
		System.out.println("Pessoa não encontrada!\n");
		pessoa = null;
	}
	
	public void editaPessoa(List<Pessoas> lista, String nome) {
		for (Pessoas p : lista) {
			if (nome.toUpperCase().equals(p.getNome())) {	
				System.out.println("\nPessoa encontrada!\n");
				System.out.println(p);
				
				String respostaEditor;
				do {
					System.out.print("\nTem certeza que deseja editar os dados pessoais (s/n): ");
					respostaEditor = sc.nextLine();
				} while(!respostaEditor.equalsIgnoreCase("s") && !respostaEditor.equalsIgnoreCase("n"));
				
				if (respostaEditor.equalsIgnoreCase("s")) {
					lista.remove(p);
					System.out.print("\nNovo nome: ");
					String novoNome = sc.next();
					System.out.print("Novo CPF: ");
					String novoCpf = sc.next();
					System.out.print("Tipo: "
								+ "\n	1 - Aluno"
								+ "\n	2 - Funcionário"
								+ "\n	3 - Terceirizado"
								+ "\n	4 - Visitante"
								+ "\nInforme a opção: ");	
					int novoTipo = sc.nextInt();
				
					if(novoTipo == 1) {
						System.out.print("Nova matrícula: ");
						Integer novaMatricula = sc.nextInt();
						System.out.print("Curso: "
								+ "\n	1  - Administração"
								+ "\n	2  - Arquitetura e Urbanismo"
								+ "\n	3  - Ciências Contábeis"
								+ "\n	4  - Direito"
								+ "\n	5  - Educação Física"
								+ "\n	6  - Enfermagem"
								+ "\n	7  - Engenharia Civil"
								+ "\n	8  - Farmácia"
								+ "\n	9  - Fisioterapia"
								+ "\n	10 - Nutrição"
								+ "\n	11 - Odontologia"
								+ "\n	12 - Psicologia"
								+ "\n	13 - Sistemas de Informação"
								+ "\n	14 - Sistemas para Internet"
								+ "\nInforme a opção: ");
						int novoCurso = sc.nextInt();
						System.out.println("\nDados pessoais editados!");
						lista.add(new Alunos(novoNome.toUpperCase(), novoCpf, TiposDePessoas.procurarOpcao(novoTipo), novaMatricula,Cursos.procurarOpcao(novoCurso)));
						return;
					}
					if(novoTipo == 2) {
						System.out.print("Novo registro de trabalho: ");
						Integer novoRegistro = sc.nextInt();
						System.out.print("Cargo: "
								+ "\n	1  - Serviços gerais"
								+ "\n	2  - Segurança"
								+ "\n	3  - Secretária"
								+ "\n	4  - Bibliotecária"
								+ "\n	5  - Telemarketing"
								+ "\n	6  - Técnico de informática"
								+ "\n	7  - RH"
								+ "\n	8  - Tesoreiro"
								+ "\n	9  - Coordenador"
								+ "\n	10 - Professor"
								+ "\n	11 - Gerente"
								+ "\n	12 - Reitor"
								+ "\nInforme a opção: ");
						int novoCargo = sc.nextInt();
						System.out.println("\nDados pessoais editados!");
						lista.add(new Funcionarios(novoNome.toUpperCase(), novoCpf, TiposDePessoas.procurarOpcao(novoTipo), novoRegistro,Cargos.procurarOpcao(novoCargo)));
						return;
					}
					if(novoTipo == 3) {
						System.out.print("Novo nome da empresa: ");
						String novaEmpresa = sc.next();
						System.out.print("Tipo de serviço: "
								+ "\n	1 - Eletricista"
								+ "\n	2 - Entregador"
								+ "\n	3 - Encanador"
								+ "\n	4 - Jardineiro"
								+ "\n	5 - Motorista"
								+ "\n	6 - Pedreiro"
								+ "\n	7 - Pintor"
								+ "\nInforme a opção: ");
						int novoTipoServico = sc.nextInt();
						System.out.println("\nDados pessoais editados!");
						lista.add(new Terceirizados(novoNome.toUpperCase(), novoCpf, TiposDePessoas.procurarOpcao(novoTipo), novaEmpresa, TiposDeServicos.procurarOpcao(novoTipoServico)));
						return;
					}
					if(novoTipo == 4) {
						System.out.print("Novo número do telefone: ");
						Integer novoNumeroTelefone = sc.nextInt();
						System.out.print("Motivo da visita: "
								+ "\n	1 - Conhecer instalações"
								+ "\n	2 - Obter informações"
								+ "\n	3 - Fazer matrícula"
								+ "\n	4 - Atendimento da clínica escola"
								+ "\n	5 - Falar com funcionário"
								+ "\n	6 - Falar com aluno"
								+ "\n	7 - Outros"
								+ "\nInforme a opção: ");
						int novoMotivo = sc.nextInt();
						System.out.println("\nDados pessoais editados!");
						lista.add(new Visitantes(novoNome.toUpperCase(), novoCpf, TiposDePessoas.procurarOpcao(novoTipo), novoNumeroTelefone, MotivosDaVisita.procurarOpcao(novoMotivo)));
						return;
					}
				}
				if (respostaEditor.equalsIgnoreCase("n")) {
					return;
				}	
			}
			System.out.println("Pessoa não encontrada!");
		}
	}
	
	public void editaPessoa(Veiculos veiculo) {
		System.out.print("\nNovo nome: ");
		String novoNome = sc.next();
		System.out.print("Novo CPF: ");
		String novoCpf = sc.next();
		System.out.print("Tipo: "
					+ "\n	1 - Aluno"
					+ "\n	2 - Funcionário"
					+ "\n	3 - Terceirizado"
					+ "\n	4 - Visitante"
					+ "\nInforme a opção: ");	
		int novoTipo = sc.nextInt();
	
		if(novoTipo == 1) {
			System.out.print("Nova matrícula: ");
			Integer novaMatricula = sc.nextInt();
			System.out.print("Curso: "
					+ "\n	1  - Administração"
					+ "\n	2  - Arquitetura e Urbanismo"
					+ "\n	3  - Ciências Contábeis"
					+ "\n	4  - Direito"
					+ "\n	5  - Educação Física"
					+ "\n	6  - Enfermagem"
					+ "\n	7  - Engenharia Civil"
					+ "\n	8  - Farmácia"
					+ "\n	9  - Fisioterapia"
					+ "\n	10 - Nutrição"
					+ "\n	11 - Odontologia"
					+ "\n	12 - Psicologia"
					+ "\n	13 - Sistemas de Informação"
					+ "\n	14 - Sistemas para Internet"
					+ "\nInforme a opção: ");
			int novoCurso = sc.nextInt();
			System.out.println("\nDados pessoais editados!");
			veiculo.setDono(new Alunos(novoNome.toUpperCase(), novoCpf, TiposDePessoas.procurarOpcao(novoTipo), novaMatricula,Cursos.procurarOpcao(novoCurso)));
			return;
		}
		if(novoTipo == 2) {
			System.out.print("Novo registro de trabalho: ");
			Integer novoRegistro = sc.nextInt();
			System.out.print("Cargo: "
					+ "\n	1  - Serviços gerais"
					+ "\n	2  - Segurança"
					+ "\n	3  - Secretária"
					+ "\n	4  - Bibliotecária"
					+ "\n	5  - Telemarketing"
					+ "\n	6  - Técnico de informática"
					+ "\n	7  - RH"
					+ "\n	8  - Tesoreiro"
					+ "\n	9  - Coordenador"
					+ "\n	10 - Professor"
					+ "\n	11 - Gerente"
					+ "\n	12 - Reitor"
					+ "\nInforme a opção: ");
			int novoCargo = sc.nextInt();
			System.out.println("\nDados pessoais editados!");
			veiculo.setDono(new Funcionarios(novoNome.toUpperCase(), novoCpf, TiposDePessoas.procurarOpcao(novoTipo), novoRegistro,Cargos.procurarOpcao(novoCargo)));
			return;
		}
		if(novoTipo == 3) {
			System.out.print("Novo nome da empresa: ");
			String novaEmpresa = sc.next();
			System.out.print("Tipo de serviço: "
					+ "\n	1 - Eletricista"
					+ "\n	2 - Entregador"
					+ "\n	3 - Encanador"
					+ "\n	4 - Jardineiro"
					+ "\n	5 - Motorista"
					+ "\n	6 - Pedreiro"
					+ "\n	7 - Pintor"
					+ "\nInforme a opção: ");
			int novoTipoServico = sc.nextInt();
			System.out.println("\nDados pessoais editados!");
			veiculo.setDono(new Terceirizados(novoNome.toUpperCase(), novoCpf, TiposDePessoas.procurarOpcao(novoTipo), novaEmpresa, TiposDeServicos.procurarOpcao(novoTipoServico)));
			return;
		}
		if(novoTipo == 4) {
			System.out.print("Novo número do telefone: ");
			Integer novoNumeroTelefone = sc.nextInt();
			System.out.print("Motivo da visita: "
					+ "\n	1 - Conhecer instalações"
					+ "\n	2 - Obter informações"
					+ "\n	3 - Fazer matrícula"
					+ "\n	4 - Atendimento da clínica escola"
					+ "\n	5 - Falar com funcionário"
					+ "\n	6 - Falar com aluno"
					+ "\n	7 - Outros"
					+ "\nInforme a opção: ");
			int novoMotivo = sc.nextInt();
			System.out.println("\nDados pessoais editados!");
			veiculo.setDono(new Visitantes(novoNome.toUpperCase(), novoCpf, TiposDePessoas.procurarOpcao(novoTipo), novoNumeroTelefone, MotivosDaVisita.procurarOpcao(novoMotivo)));
			return;
		}
	}
	
	public void excluiPessoa(List<Pessoas> lista, String nome) {
		for (Pessoas p : lista) {
			if (nome.toUpperCase().toUpperCase().equals(p.getNome())) {
				System.out.println("\nPessoa encontrada!\n");
				System.out.println(p);
				String resposta;
				do {
					System.out.print("\nTem certeza que deseja excluir (s/n): ");
					resposta = sc.nextLine();
				} while(!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n"));
				
				if (resposta.equalsIgnoreCase("s")) {
					System.out.println("Pessoa excluida!");
					lista.remove(p);
					return;
				}
				if (resposta.equalsIgnoreCase("n")) {
					return;
				}	
			}
		}
		System.out.println("Pessoa não encontrada!\n");
	}
	
	public Pessoas getPessoa() {
		return pessoa;
	}
}
