package br.com.ifomeadaf1rst.model;

import java.util.UUID;
import java.util.regex.Pattern;

import br.com.ifomeadaf1rst.enums.TipoVeiculoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
public class Veiculo {

	public static final int ANO_MINIMO = 2010;
	public static final String FORMATO_PLACA_MERCOSUL = "^[a-zA-Z]{3}[\\d][A-Za-z\\d][\\d]{2}$";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private UUID id;
	private TipoVeiculoEnum tipo;
	private String marca;
	private String placa;
	private String cor;
	@Column(unique = true)
	private Long renavan;
	private boolean ativo;
	private int ano;

	public boolean isValid(){
		if (TipoVeiculoEnum.BICICLETA.equals(tipo))
			return true;

		return ANO_MINIMO <= ano && Pattern.matches(FORMATO_PLACA_MERCOSUL, placa);
	}
}
