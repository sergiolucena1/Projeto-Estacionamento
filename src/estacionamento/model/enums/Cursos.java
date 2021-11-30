package estacionamento.model.enums;

public enum Cursos {
	
	ADMINISTRACAO(1),
	ARQUITETURA_E_URBANISMO(2),
	CIENCIAS_CONTABEIS(3),
	DIREITO(4),
	EDUCACAO_FISICA(5),
	ENFERMAGEM(6),
	ENGENHARIA_CIVIL(7),
	FARMACIA(8),
	FISIOTERAPIA(9),
	NUTRICAO(10),
	ODONTOLOGIA(11),
	PSICOLOGIA(12),
	SISTEMAS_DE_INFORMACAO(13),
	SISTEMAS_PARA_INTERNET(14);
	
	private int opcao;

	Cursos(int opcaoEscolhida) {
		opcao = opcaoEscolhida;
	}

	public int getOpcao() {
		return opcao;
	}
	
	public static Cursos procurarOpcao(int opcao) {
		for(Cursos curso : values()) {
            if (curso.getOpcao() == opcao)
                return curso;
        }
        return null;
	}
}
