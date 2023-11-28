package br.com.ifomeadaf1rst.model;

import java.util.Date;
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
public class Documento {
	
	@Id
	private UUID id;
	private String estado;
	private Long numero;
	private Character categoria;
	private Date dataVencimento;
	private Date dataEmissao;
	
}
