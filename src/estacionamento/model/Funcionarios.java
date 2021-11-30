package estacionamento.model;

import estacionamento.model.enums.Cargos;
import estacionamento.model.enums.TiposDePessoas;

public class Funcionarios extends Pessoas {

	private Integer registroDeTrabalho;
	private Cargos cargo;

	public Funcionarios(String nome, String cpf, TiposDePessoas tipo, Integer registro, Cargos cargo) {
		super(nome, cpf, tipo);
		this.registroDeTrabalho = registro;
		this.cargo = cargo;
	}

	public Integer getRegistroDeTrabalho() {
		return registroDeTrabalho;
	}

	public Cargos getCargo() {
		return cargo;
	}
	
	public void setRegistroDeTrabalho(Integer registro) {
		this.registroDeTrabalho = registro;
	}

	public void setCargo(Cargos cargo) {
		this.cargo = cargo;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Registro: %-11s ,Cargo: %-25s", registroDeTrabalho, cargo));
		return super.toString() + sb.toString();
	}

}
