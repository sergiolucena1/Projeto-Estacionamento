package estacionamento.service;

import java.time.LocalDateTime;
import java.util.List;

import estacionamento.model.VagasEstacionamento;
import estacionamento.model.Veiculos;
import estacionamento.repositorio.EstacionamentoRepositorio;
import estacionamento.repositorio.PessoaRepositorio;
import estacionamento.repositorio.VeiculoRepositorio;

public class EstacionamentoService {
	
	private Veiculos veiculo;
	private VeiculoService vs = new VeiculoService();
	
	public void entradaDeVeiculo(PessoaRepositorio dadosPessoa, VeiculoRepositorio dadosVeiculos, EstacionamentoRepositorio dadosEstacionamento, String placaDoVeiculo) {
		vs.consultaVeiculo(dadosVeiculos.getListaVeiculosCadastrados(), placaDoVeiculo);
		veiculo = vs.getVeiculo();
		if (veiculo == null) {
			vs.cadastraVeiculo(dadosVeiculos, dadosPessoa);
			veiculo = vs.getVeiculo();
			dadosEstacionamento.adicionarEntradaDeVeiculoAoBandoDeDados(new VagasEstacionamento(veiculo, LocalDateTime.now()));
			dadosEstacionamento.adicionarUsoDeVaga(new VagasEstacionamento(veiculo, LocalDateTime.now()));
			System.out.println("\nEntrada cadastrada com sucesso!\n");
		}
		dadosEstacionamento.adicionarEntradaDeVeiculoAoBandoDeDados(new VagasEstacionamento(veiculo, LocalDateTime.now()));
		dadosEstacionamento.adicionarUsoDeVaga(new VagasEstacionamento(veiculo, LocalDateTime.now()));
		System.out.println("\nEntrada cadastrada com sucesso!\n");
	}

	public void saidaDeVeiculo(PessoaRepositorio dadosPessoa, VeiculoRepositorio dadosVeiculo,	EstacionamentoRepositorio dadosEstacionamento, String placaDoVeiculo) {
		consultaVeiculo(dadosEstacionamento.getListaDeVagasEmUso(), placaDoVeiculo);
		veiculo = vs.getVeiculo();
		if (veiculo == null) {
			System.out.println("\nVeículo não encontrado!");
			return;
		}
		System.out.println("\nSaída cadastrada com sucesso!\n");
		dadosEstacionamento.encerrarUsoDeVaga(null);
	}
	
	public void consultaVeiculo(List<VagasEstacionamento> lista, String placa) {
		for (VagasEstacionamento v : lista) {
			if (placa.toUpperCase().equals(v.getVeiculo().getPlacaDoVeiculo())) {
				System.out.println("\nVeículo encontrado!");
				veiculo = v.getVeiculo();
				System.out.println(v);
				return;
			}
		}
		veiculo = null;
		System.out.println("\nVeículo não encontrado!\n");
	}

}
