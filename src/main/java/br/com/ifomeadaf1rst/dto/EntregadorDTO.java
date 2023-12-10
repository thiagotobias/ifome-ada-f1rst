package br.com.ifomeadaf1rst.dto;

import java.util.Date;
import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import br.com.ifomeadaf1rst.enums.TipoChaveEnum;
import br.com.ifomeadaf1rst.enums.TipoContaEnum;
import br.com.ifomeadaf1rst.enums.TipoVeiculoEnum;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EntregadorDTO {
	
	private UUID id;
	
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "CPF é obrigatório")
	@CPF
	
	private String cpf;
	@NotBlank(message = "E-mail é obrigatório")
	@Email
	private String email;
	
	@NotBlank(message = "Banco é obrigatório")
	private String banco;
	
	@NotBlank(message = "Agencia é obrigatório")
	private String agencia;
	
	@NotBlank(message = "Conta é obrigatório")
	private String conta;
	
	@NotNull(message = "Digito da conta é obrigatório")
	private Integer digitoConta;
	
	@NotNull(message = "Tipo de Conta é obrigatório")
	private TipoContaEnum tipoConta;
	
	@NotNull(message = "Tipo de Chave é obrigatório")
	private TipoChaveEnum tipoChave;
	
	@NotBlank(message = "Valor da Chave é obrigatório")
	private String chave;
	
	@NotBlank(message = "UF da Habilitação é obrigatório")
	private String ufDocumento;
	
	@NotNull(message = "Número da Habilitação é obrigatório")
    @Digits(integer = 11, fraction = 0, message = "Número da Habilitação deve conter 11 dígitos")
	private Long numeroDocumento;
	
	@NotBlank(message = "Categoria da Habilitação é obrigatório")
	@Size(min = 1, max = 1, message = "Tipo da Habilitação deve conter 1 caracteres")
	private String categoriaDocumento;
	
	@NotNull(message = "Data de Vencimento da Habilitação é obrigatório")
	private Date dataVencimentoDocumento;
	
	@NotNull(message = "Data de Emissão da Habilitação é obrigatório")
	private Date dataEmisssaoDocumento;
	private String tamanhoCamisa;
	
	@NotNull(message = "Tipo de Veículo é obrigatório")
	private TipoVeiculoEnum tipoVeiculoEnum;
	
	private String marcaVeiculo;
	private String placaVeiculo;
	private String corVeiculo;
	private Long renavam;
	private Integer anoVeiculo;
	
	@NotBlank(message = "Logradouro é obrigatório")
	private String logradouro;
	
	@NotNull(message = "Número do endereço é obrigatório")
	private Long numeroEndereco;
	private String complementoEndereco;
	
	@NotBlank(message = "CEP é obrigatório")
	private String cep;
}
