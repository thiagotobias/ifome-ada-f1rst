package br.com.ifomeadaf1rst.enums;

public enum TipoVeiculoEnum {
	
	MOTOCICLETA("A"),
	CARRO("B"),
	CAMINHONETES("C"),
	ÔNIBUS("D"),
	CAMINHÃO("E"),
	BICICLETA("F");

    private final String tipoVeiculoEnum;

    TipoVeiculoEnum(String tipoVeiculoEnum) {
        this.tipoVeiculoEnum = tipoVeiculoEnum;
    }

    public String getTipoVeiculoEnum() {
        return tipoVeiculoEnum;
    }
    
    public static TipoVeiculoEnum fromString(String tipo) {
        for (TipoVeiculoEnum tipoVeiculoEnum : TipoVeiculoEnum.values()) {
            if (tipoVeiculoEnum.tipoVeiculoEnum.equalsIgnoreCase(tipo)) {
                return tipoVeiculoEnum;
            }
        }
        throw new IllegalArgumentException("Tipo de veículo não encontrado para: " + tipo);
    }
}
