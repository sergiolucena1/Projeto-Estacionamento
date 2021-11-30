package estacionamento.model;

import java.util.ArrayList;
import java.util.List;

import estacionamento.model.enums.Marcas;
import estacionamento.model.enums.TiposDeVeiculos;

public class Veiculos {

	private TiposDeVeiculos tipo;
	private Marcas marca;
	private String placaDoVeiculo;
	private Pessoas dono;
	private List<Pessoas> listaOcupantes = new ArrayList<>();
	
	public Veiculos(TiposDeVeiculos tipo, Marcas marca, String placaDoVeiculo, Pessoas dono) {
		this.tipo = tipo;
		this.marca = marca;
		this.placaDoVeiculo = placaDoVeiculo;
		this.dono = dono;
	}

	public TiposDeVeiculos getTipo() {
		return tipo;
	}

	public void setTipo(TiposDeVeiculos tipo) {
		this.tipo = tipo;
	}

	public Marcas getMarca() {
		return marca;
	}

	public void setMarca(Marcas marca) {
		this.marca = marca;
	}

	public String getPlacaDoVeiculo() {
		return placaDoVeiculo;
	}

	public void setPlacaDoVeiculo(String placaDoVeiculo) {
		this.placaDoVeiculo = placaDoVeiculo;
	}

	public Pessoas getDono() {
		return dono;
	}

	public void setDono(Pessoas dono) {
		this.dono = dono;
	}

	public List<Pessoas> getListaOcupantes() {
		return listaOcupantes;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("\nTipo: %-6s, Placa: %-8s, Marca: %-10s, Nome do dono: %-15s, CPF: %-14s, Tipo: %-12s", tipo, placaDoVeiculo, marca, dono.getNome(), dono.getCpf(), dono.getTipo()));
		return sb.toString();
	}
	

}
