package estacionamento.model.enums;

public enum Marcas {
	
	AUDI(1),
	BMW(2),
	CHEVROLET(3),
	CITROEN(4),
	FIAT(5),
	FORD(6),
	HYUNDAI(7),
	HONDA(8),
	JAGUAR(9),
	LAND_ROVER(10),
	PEUGEOT(11),
	TOYOTA(12),
	VOLKSWAGEN(13),	
	VOLVO(14),
	OUTRO(15);
	
	private int opcao;

	Marcas(int opcaoEscolhida) {
		opcao = opcaoEscolhida;
	}

	public int getOpcao() {
		return opcao;
	}
	
	public static Marcas procurarOpcao(int opcao) {
		for(Marcas marca : values()) {
            if (marca.getOpcao() == opcao)
                return marca;
        }
        return null;
	}
}
