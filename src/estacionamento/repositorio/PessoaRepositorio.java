package estacionamento.repositorio;

import java.util.ArrayList;
import java.util.List;

import estacionamento.model.Alunos;
import estacionamento.model.Funcionarios;
import estacionamento.model.Pessoas;
import estacionamento.model.Terceirizados;
import estacionamento.model.Visitantes;
import estacionamento.model.enums.Cargos;
import estacionamento.model.enums.Cursos;
import estacionamento.model.enums.MotivosDaVisita;
import estacionamento.model.enums.TiposDePessoas;
import estacionamento.model.enums.TiposDeServicos;

public class PessoaRepositorio {
	
	private List<Pessoas> listaPessoasCadastradas = new ArrayList<>();
	
	public void adicionarAoPessoaBandoDeDados(Pessoas pessoa) {
		listaPessoasCadastradas.add(pessoa);
	}
	
	public List<Pessoas> getListaPessoasCadastradas() {
		return listaPessoasCadastradas;
	}

	public void backup() {
		listaPessoasCadastradas.add(new Alunos("Aluno1", "000.000.000-01", TiposDePessoas.procurarOpcao(1), 20211, Cursos.procurarOpcao(1)));
		listaPessoasCadastradas.add(new Alunos("Aluno2", "000.000.000-02", TiposDePessoas.procurarOpcao(1), 20212, Cursos.procurarOpcao(2)));
		listaPessoasCadastradas.add(new Alunos("Aluno3", "000.000.000-03", TiposDePessoas.procurarOpcao(1), 20213, Cursos.procurarOpcao(3)));
		
		listaPessoasCadastradas.add(new Funcionarios("Funcionário1", "000.000.000-04", TiposDePessoas.procurarOpcao(2), 000001, Cargos.procurarOpcao(1)));
		listaPessoasCadastradas.add(new Funcionarios("Funcionário2", "000.000.000-05", TiposDePessoas.procurarOpcao(2), 000002, Cargos.procurarOpcao(2)));
		listaPessoasCadastradas.add(new Funcionarios("Funcionário3", "000.000.000-06", TiposDePessoas.procurarOpcao(2), 000003, Cargos.procurarOpcao(3)));
		
		listaPessoasCadastradas.add(new Terceirizados("Tercerizado1", "000.000.000-07", TiposDePessoas.procurarOpcao(3), "Empresa1" , TiposDeServicos.procurarOpcao(1)));
		listaPessoasCadastradas.add(new Terceirizados("Tercerizado2", "000.000.000-08", TiposDePessoas.procurarOpcao(3), "Empresa2" , TiposDeServicos.procurarOpcao(2)));
		listaPessoasCadastradas.add(new Terceirizados("Tercerizado3", "000.000.000-09", TiposDePessoas.procurarOpcao(3), "Empresa3" , TiposDeServicos.procurarOpcao(3)));
		
		listaPessoasCadastradas.add(new Visitantes("Visitante1", "000.000.000-10", TiposDePessoas.procurarOpcao(4), 99999997, MotivosDaVisita.procurarOpcao(1)));
		listaPessoasCadastradas.add(new Visitantes("Visitante2", "000.000.000-11", TiposDePessoas.procurarOpcao(4), 99999998, MotivosDaVisita.procurarOpcao(1)));
		listaPessoasCadastradas.add(new Visitantes("Visitante3", "000.000.000-12", TiposDePessoas.procurarOpcao(4), 99999999, MotivosDaVisita.procurarOpcao(1)));
	}

}
