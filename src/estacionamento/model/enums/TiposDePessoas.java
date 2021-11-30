package estacionamento.model.enums;

public enum TiposDePessoas {
	
	ALUNO(1),
	FUNCIONARIO(2),
	TERCEIRIZADO(3),
	VISITANTE(4);
	
	private int opcao;

	TiposDePessoas(int opcaoEscolhida) {
		opcao = opcaoEscolhida;
	}

	public int getOpcao() {
		return opcao;
	}
	
	public static TiposDePessoas procurarOpcao(int opcao) {
		for(TiposDePessoas tipo : values()) {
            if (tipo.getOpcao() == opcao)
                return tipo;
        }
        return null;
	}

}
