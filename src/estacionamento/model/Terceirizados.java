package estacionamento.model;

import estacionamento.model.enums.TiposDePessoas;
import estacionamento.model.enums.TiposDeServicos;

public class Terceirizados extends Pessoas {
	
	private String nomeDaEmpresa;
	private TiposDeServicos servico;
	
	public Terceirizados(String nome, String cpf, TiposDePessoas tipo, String nomeDaEmpresa, TiposDeServicos servico) {
		super(nome, cpf, tipo);
		this.nomeDaEmpresa = nomeDaEmpresa;
		this.servico = servico;
	}

	public String getNomeDaEmpresa() {
		return nomeDaEmpresa;
	}

	public void setNomeDaEmpresa(String nomeDaEmpresa) {
		this.nomeDaEmpresa = nomeDaEmpresa;
	}

	public TiposDeServicos getServico() {
		return servico;
	}
	
	public void setServico(TiposDeServicos servico) {
		this.servico = servico;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Empresa: %-12s ,Serviço: %-23s", nomeDaEmpresa, servico));
		return super.toString() + sb.toString();
	}
	

}
