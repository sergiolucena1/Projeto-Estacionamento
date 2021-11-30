package estacionamento.model;

import estacionamento.model.enums.MotivosDaVisita;
import estacionamento.model.enums.TiposDePessoas;

public class Visitantes extends Pessoas {
	
	private Integer telefone;
	private MotivosDaVisita motivo;
	
	public Visitantes(String nome, String cpf, TiposDePessoas tipo, Integer telefone, MotivosDaVisita motivo) {
		super(nome, cpf, tipo);
		this.telefone = telefone;
		this.motivo = motivo;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public MotivosDaVisita getMotivo() {
		return motivo;
	}

	public void setMotivo(MotivosDaVisita motivo) {
		this.motivo = motivo;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Telefone: %-11s ,Motivo: %-24s", telefone, motivo));
		return super.toString() + sb.toString();
	}
	

}
