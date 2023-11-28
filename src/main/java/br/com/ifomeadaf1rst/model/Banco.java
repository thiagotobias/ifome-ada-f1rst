package br.com.ifomeadaf1rst.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
public class Banco {

	@Id
	private UUID id;
	private String nome;
	private String cnpj;
	private Long numero;

}
