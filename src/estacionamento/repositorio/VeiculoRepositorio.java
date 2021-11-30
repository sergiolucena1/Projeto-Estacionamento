package estacionamento.repositorio;

import java.util.ArrayList;
import java.util.List;

import estacionamento.model.Alunos;
import estacionamento.model.Funcionarios;
import estacionamento.model.Terceirizados;
import estacionamento.model.Veiculos;
import estacionamento.model.Visitantes;
import estacionamento.model.enums.Cargos;
import estacionamento.model.enums.Cursos;
import estacionamento.model.enums.Marcas;
import estacionamento.model.enums.MotivosDaVisita;
import estacionamento.model.enums.TiposDePessoas;
import estacionamento.model.enums.TiposDeServicos;
import estacionamento.model.enums.TiposDeVeiculos;

public class VeiculoRepositorio {

	private List<Veiculos> listaVeiculosCadastrados = new ArrayList<>();
	
	public void adicionarAoVeiculoAoBandoDeDados(Veiculos veiculo) {
		listaVeiculosCadastrados.add(veiculo);
	}

	public List<Veiculos> getListaVeiculosCadastrados() {
		return listaVeiculosCadastrados;
	}
	
	public void backup() {
		listaVeiculosCadastrados.add(new Veiculos(TiposDeVeiculos.CARRO, Marcas.AUDI, "AAA-0001", new Alunos("Dono1", "000.000.000-13", TiposDePessoas.procurarOpcao(1), 20214, Cursos.procurarOpcao(4))));
		listaVeiculosCadastrados.add(new Veiculos(TiposDeVeiculos.CARRO, Marcas.BMW, "AAA-0002", new Funcionarios("Dono2", "000.000.000-14", TiposDePessoas.procurarOpcao(2), 000004, Cargos.procurarOpcao(4))));
		listaVeiculosCadastrados.add(new Veiculos(TiposDeVeiculos.CARRO, Marcas.CHEVROLET, "AAA-0003", new Terceirizados("Dono3", "000.000.000-15", TiposDePessoas.procurarOpcao(3), "Empresa4" , TiposDeServicos.procurarOpcao(4))));
		listaVeiculosCadastrados.add(new Veiculos(TiposDeVeiculos.CARRO, Marcas.CITROEN, "AAA-0004", new Visitantes("Dono4", "000.000.000-16", TiposDePessoas.procurarOpcao(3), 99999996, MotivosDaVisita.procurarOpcao(4))));
		
		listaVeiculosCadastrados.add(new Veiculos(TiposDeVeiculos.MOTO, Marcas.HONDA, "AAA-0005", new Alunos("Dono5", "000.000.000-17", TiposDePessoas.procurarOpcao(1), 20215, Cursos.procurarOpcao(5))));
		listaVeiculosCadastrados.add(new Veiculos(TiposDeVeiculos.MOTO, Marcas.HONDA, "AAA-0006", new Funcionarios("Dono6", "000.000.000-18", TiposDePessoas.procurarOpcao(2), 000005, Cargos.procurarOpcao(5))));
		listaVeiculosCadastrados.add(new Veiculos(TiposDeVeiculos.MOTO, Marcas.HONDA, "AAA-0007", new Terceirizados("Dono7", "000.000.000-19", TiposDePessoas.procurarOpcao(3), "Empresa5" , TiposDeServicos.procurarOpcao(5))));
		listaVeiculosCadastrados.add(new Veiculos(TiposDeVeiculos.MOTO, Marcas.HONDA, "AAA-0008", new Visitantes("Dono8", "000.000.000-20", TiposDePessoas.procurarOpcao(3), 99999995, MotivosDaVisita.procurarOpcao(5))));
		
		listaVeiculosCadastrados.add(new Veiculos(TiposDeVeiculos.VAN, Marcas.FORD, "AAA-0009", new Alunos("Dono9", "000.000.000-21", TiposDePessoas.procurarOpcao(1), 20216, Cursos.procurarOpcao(6))));
		listaVeiculosCadastrados.add(new Veiculos(TiposDeVeiculos.VAN, Marcas.FIAT, "AAA-0010", new Funcionarios("Dono10", "000.000.000-22", TiposDePessoas.procurarOpcao(2), 000006, Cargos.procurarOpcao(6))));
		listaVeiculosCadastrados.add(new Veiculos(TiposDeVeiculos.VAN, Marcas.HYUNDAI, "AAA-0011", new Terceirizados("Dono11", "000.000.000-23", TiposDePessoas.procurarOpcao(3), "Empresa6" , TiposDeServicos.procurarOpcao(6))));
		listaVeiculosCadastrados.add(new Veiculos(TiposDeVeiculos.VAN, Marcas.PEUGEOT, "AAA-0012", new Visitantes("Dono12", "000.000.000-24", TiposDePessoas.procurarOpcao(3), 99999994, MotivosDaVisita.procurarOpcao(6))));
		
		listaVeiculosCadastrados.add(new Veiculos(TiposDeVeiculos.ONIBUS, Marcas.VOLKSWAGEN, "AAA-0013", new Alunos("Dono13", "000.000.000-25", TiposDePessoas.procurarOpcao(1), 20217, Cursos.procurarOpcao(7))));
		listaVeiculosCadastrados.add(new Veiculos(TiposDeVeiculos.ONIBUS, Marcas.VOLVO, "AAA-0014", new Funcionarios("Dono14", "000.000.000-26", TiposDePessoas.procurarOpcao(2), 000007, Cargos.procurarOpcao(7))));
		listaVeiculosCadastrados.add(new Veiculos(TiposDeVeiculos.ONIBUS, Marcas.OUTRO, "AAA-0015", new Terceirizados("Dono15", "000.000.000-27", TiposDePessoas.procurarOpcao(3), "Empresa7" , TiposDeServicos.procurarOpcao(7))));
		listaVeiculosCadastrados.add(new Veiculos(TiposDeVeiculos.ONIBUS, Marcas.CHEVROLET, "AAA-0016", new Visitantes("Dono16", "000.000.000-28", TiposDePessoas.procurarOpcao(3), 99999993, MotivosDaVisita.procurarOpcao(7))));
	}

}