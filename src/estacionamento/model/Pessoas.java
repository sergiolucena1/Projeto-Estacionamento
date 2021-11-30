package estacionamento.model;

import estacionamento.model.enums.TiposDePessoas;

public abstract class Pessoas {
	
	private String nome;
	private String cpf;
	private TiposDePessoas tipo;

	public Pessoas(String nome, String cpf, TiposDePessoas tipo) {
		this.nome = nome;
		this.cpf = cpf;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public TiposDePessoas getTipo() {
		return tipo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setTipo(TiposDePessoas tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("\nNome: %-15s ,CPF: %-14s ,Tipo: %-12s , ", nome, cpf, tipo));
		return sb.toString();
	}
}
