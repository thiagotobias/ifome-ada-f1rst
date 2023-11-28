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
public class Endereco {

	@Id
	private UUID id;
	private String logradouro;
	private String complemento;
	private String cep;

}
