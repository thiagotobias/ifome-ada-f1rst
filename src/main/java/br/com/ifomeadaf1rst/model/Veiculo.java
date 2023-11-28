package br.com.ifomeadaf1rst.model;

import java.util.UUID;

import br.com.ifomeadaf1rst.enums.TipoVeiculoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
public class Veiculo {
	
	@Id
	private UUID id;
	private TipoVeiculoEnum tipo;
	private String marca;
	private String placa;
	private String cor;
	private Long renaVan;
	private Boolean ativo;

}
