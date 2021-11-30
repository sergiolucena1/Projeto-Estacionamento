package estacionamento.model.enums;

public enum MotivosDaVisita {
	
	CONHECER_INSTALACOES(1),
	OBTER_INFORMCOES(2),
	FAZER_MATRICULA(3),
	ATENDIMENTO_CLINICA_ESCOLA(4),
	FALAR_COM_FUNCIONARIO(5),
	FALAR_COM_ALUNO(6),
	OUTROS(7);	

	private int opcao;

	MotivosDaVisita(int opcaoEscolhida) {
		opcao = opcaoEscolhida;
	}

	public int getOpcao() {
		return opcao;
	}
	
	public static MotivosDaVisita procurarOpcao(int opcao) {
		for(MotivosDaVisita motivo : values()) {
            if (motivo.getOpcao() == opcao)
                return motivo;
        }
        return null;
	}
}
