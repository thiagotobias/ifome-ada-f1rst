package br.com.ifomeadaf1rst.model;

import java.time.LocalDate;
import java.util.UUID;

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
public class Documento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String estado;
	private Long numero;
	private Character categoria;
	private LocalDate dataVencimento;
	private LocalDate dataEmissao;

	public boolean isValid(){
		return LocalDate.now().isBefore(dataVencimento);
	}
}
