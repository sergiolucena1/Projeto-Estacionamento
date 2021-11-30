package estacionamento.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VagasEstacionamento {
	
	private Veiculos veiculo;
	private LocalDateTime dataHoraEntrada;
	private LocalDateTime dataHoraSaida = null;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
	
	public VagasEstacionamento(Veiculos veiculo, LocalDateTime dataHoraEntrada) {
		this.veiculo = veiculo;
		this.dataHoraEntrada = dataHoraEntrada;
	}

	public Veiculos getVeiculo() {
		return veiculo;
	}

	public LocalDateTime getDataHoraEntrada() {
		return dataHoraEntrada;
	}

	public LocalDateTime getDataHoraSaida() {
		return dataHoraSaida;
	}
	
	public void setDataHoraSaida(LocalDateTime dataHoraSaida) {
		this.dataHoraSaida = dataHoraSaida;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String dataSaida = "AINDA ESTACIONADO  ";
		sb.append("\nEntrada: " + dataHoraEntrada.format(dtf) + ", Saída: " + dataSaida);

		if (dataHoraSaida != null) {
			dataSaida =  dataHoraSaida.format(dtf);
		} 
		sb.append(", ");
		return sb.toString() + veiculo;
	}

}
