package br.com.ifomeadaf1rst.model;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
public class DadosBancarios {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String numeroConta;
	private Integer digitoConta;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chavePix_id", referencedColumnName = "id")
	private ChavePix chavePixId;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "banco_id", referencedColumnName = "id")
	private Banco bancoId;
}
