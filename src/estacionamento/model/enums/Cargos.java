package estacionamento.model.enums;

public enum Cargos {
	
	SERVICOS_GERAIS(1),
	SEGURANCA(2),
	SECRETARIA(3),
	BIBLIOTECARIO(4),
	TELEMARKETING(5),
	TECNICO_DE_INFORMATICA(6),
	RH(7),
	TESOREIRO(8),
	COORDENADOR(9),
	PROFESSOR(10),
	GERENTE(11),
	REITOR(12);

	private int opcao;

	Cargos(int opcaoEscolhida) {
		opcao = opcaoEscolhida;
	}

	public int getOpcao() {
		return opcao;
	}
	
	public static Cargos procurarOpcao(int opcao) {
		for(Cargos cargo : values()) {
            if (cargo.getOpcao() == opcao)
                return cargo;
        }
        return null;
	}

}
