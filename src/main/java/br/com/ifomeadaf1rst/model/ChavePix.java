package br.com.ifomeadaf1rst.model;

import java.util.UUID;

import br.com.ifomeadaf1rst.enums.TipoChaveEnum;
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
public class ChavePix {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String valor;
	private TipoChaveEnum tipoChave;
}
