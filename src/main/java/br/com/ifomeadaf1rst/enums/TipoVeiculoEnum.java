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
}
