package estacionamento.model.enums;

public enum TiposDeVeiculos {
	
	CARRO(1),
	MOTO(2),
	ONIBUS(3),
	VAN(4);
	
	private int opcao;

	TiposDeVeiculos(int opcaoEscolhida) {
		opcao = opcaoEscolhida;
	}

	public int getOpcao() {
		return opcao;
	}
	
	public static TiposDeVeiculos procurarOpcao(int opcao) {
		for(TiposDeVeiculos tipo : values()) {
            if (tipo.getOpcao() == opcao)
                return tipo;
        }
        return null;
	}


}
