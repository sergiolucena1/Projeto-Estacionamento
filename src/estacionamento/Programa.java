package estacionamento;


import estacionamento.repositorio.EstacionamentoRepositorio;
import estacionamento.repositorio.PessoaRepositorio;
import estacionamento.repositorio.VeiculoRepositorio;
import estacionamento.veiw.Inicializador;

public class Programa {
	
	public static void main(String[] args) {
		
		PessoaRepositorio pr = new PessoaRepositorio();
		VeiculoRepositorio vr = new VeiculoRepositorio();
		EstacionamentoRepositorio er = new EstacionamentoRepositorio();
		Inicializador i = new Inicializador();
		pr.backup();
		vr.backup();
		i.inicializaPrograma(pr, vr, er);
	}

}
