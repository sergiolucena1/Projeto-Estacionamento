package estacionamento.repositorio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import estacionamento.model.VagasEstacionamento;

public class EstacionamentoRepositorio {

	private List<VagasEstacionamento> listaTotalDeEntradasNoEstacionamento = new ArrayList<>();
	private List<VagasEstacionamento> listaDeVagasEmUso = new ArrayList<>();

	public void adicionarEntradaDeVeiculoAoBandoDeDados(VagasEstacionamento entrada) {
		listaTotalDeEntradasNoEstacionamento.add(entrada);
	}
	
	public void adicionarUsoDeVaga(VagasEstacionamento entrada) {
		listaDeVagasEmUso.add(entrada);
	}
	
	public void encerrarUsoDeVaga(VagasEstacionamento saida) {
		saida.setDataHoraSaida(LocalDateTime.now());
		listaDeVagasEmUso.remove(saida);
	}

	public List<VagasEstacionamento> getListaDeEntradasNoEstacionamento() {
		return listaTotalDeEntradasNoEstacionamento;
	}

	public List<VagasEstacionamento> getListaDeVagasEmUso() {
		return listaDeVagasEmUso;
	}
}
