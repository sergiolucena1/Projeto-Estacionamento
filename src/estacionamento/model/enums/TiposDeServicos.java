package estacionamento.model.enums;

public enum TiposDeServicos {
	
	ELETRICISTA(1),
	ENTREGADOR(2),
	ENCANADOR(3),
	JARDINEIRO(4),
	MOTORISTA(5),
	PEDREIRO(6),
	PINTOR(7);
	
	private int opcao;

	TiposDeServicos(int opcaoEscolhida) {
		opcao = opcaoEscolhida;
	}

	public int getOpcao() {
		return opcao;
	}
	
	public static TiposDeServicos procurarOpcao(int opcao) {
		for(TiposDeServicos tipo : values()) {
            if (tipo.getOpcao() == opcao)
                return tipo;
        }
        return null;
	}
}
