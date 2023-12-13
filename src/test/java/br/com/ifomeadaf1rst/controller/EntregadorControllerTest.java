package br.com.ifomeadaf1rst.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ifomeadaf1rst.dto.EntregadorDTO;
import br.com.ifomeadaf1rst.enums.TipoContaEnum;
import br.com.ifomeadaf1rst.enums.TipoVeiculoEnum;
import br.com.ifomeadaf1rst.exception.BusinessException;
import br.com.ifomeadaf1rst.model.Entregador;
import br.com.ifomeadaf1rst.repository.EntregadorRepository;
import br.com.ifomeadaf1rst.service.EntregadorService;
import br.com.ifomeadaf1rst.service.impl.EntregadorServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EntregadorControllerTest {
	
	@InjectMocks
	@Spy
	private EntregadorController controller;
	
	@InjectMocks
	@Spy
	private EntregadorService service = Mockito.spy(EntregadorServiceImpl.class);
	
	@Mock
	private EntregadorRepository entregadorRepository;
	
	@Spy
	private ServletUriComponentsBuilder asdf;
	
	@Test
    public void testEntregadorController() {
		
		Entregador entregadorRep = new Entregador();
		entregadorRep.setId(UUID.randomUUID());
		Mockito.when(this.entregadorRepository.save(ArgumentMatchers.any(Entregador.class))).thenReturn(entregadorRep) ;
		
		 MockHttpServletRequest request = new MockHttpServletRequest();
		 RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		 URI location = ServletUriComponentsBuilder
				 		.fromCurrentRequest()
				 		.path("/{id}")
				 		.buildAndExpand(entregadorRep.getId()).toUri();
				
		EntregadorDTO entregador = new EntregadorDTO();
		entregador.setNome("Maria Joaquina");
		entregador.setCpf("44568600065");
		entregador.setRg("3520374");
		entregador.setEmail("emaildeteste@gmail.com");
		entregador.setBancoNome("Santander");
		entregador.setBanco("0033");
		entregador.setBancoCNPJ("16407431000107");
		entregador.setAgencia("00001");
		entregador.setConta("00000001");
		entregador.setDigitoConta(0);
		entregador.setTipoConta(TipoContaEnum.CORRENTE);
		entregador.setChave("thiagotobias@gmail.com");
		entregador.setUfCNH("SP");
		entregador.setNumeroCNH(71662410467L);
		entregador.setCategoriaCNH("B");
		entregador.setDataVencimentoCNH(LocalDate.of(2025, 12, 30) );
		entregador.setDataEmisssaoCNH(LocalDate.of(2020, 12, 30));
		entregador.setTamanhoCamisa("");
		entregador.setTipoVeiculoEnum(TipoVeiculoEnum.CARRO);
		entregador.setMarcaVeiculo("");
		entregador.setPlacaVeiculo("ABC1A44");
		entregador.setCorVeiculo("");
		entregador.setRenavam(11457286143L);
		entregador.setAnoVeiculo(2010);
		entregador.setLogradouro("Rua nome da rua");
		entregador.setNumeroEndereco(55L);
		entregador.setComplementoEndereco("");
		entregador.setCep("04455310");
		
		ResponseEntity<EntregadorDTO> response = ResponseEntity.created(location).build();
		Assertions.assertNotNull(this.controller.create(entregador), "Response must have 1 DTO.");
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode(), "HTTP Status should be CREATED");

    }
	
	@Test
    public void testEntregadorControllerErroNumeroAgencia() {

		EntregadorDTO entregador = new EntregadorDTO();
		entregador.setNome("Maria Joaquina");
		entregador.setCpf("44568600065");
		entregador.setRg("3520374");
		entregador.setEmail("emaildeteste@gmail.com");
		entregador.setBancoNome("Santander");
		entregador.setBanco("0033");
		entregador.setBancoCNPJ("16407431000107");
		entregador.setAgencia("000a01");
		entregador.setConta("00000001");
		entregador.setDigitoConta(0);
		entregador.setTipoConta(TipoContaEnum.CORRENTE);
		entregador.setChave("thiagotobias@gmail.com");
		entregador.setUfCNH("SP");
		entregador.setNumeroCNH(71662410467L);
		entregador.setCategoriaCNH("B");
		entregador.setDataVencimentoCNH(LocalDate.of(2025, 12, 30) );
		entregador.setDataEmisssaoCNH(LocalDate.of(2020, 12, 30));
		entregador.setTamanhoCamisa("");
		entregador.setTipoVeiculoEnum(TipoVeiculoEnum.CARRO);
		entregador.setMarcaVeiculo("");
		entregador.setPlacaVeiculo("ABC1A44");
		entregador.setCorVeiculo("");
		entregador.setRenavam(11457286143L);
		entregador.setAnoVeiculo(2010);
		entregador.setLogradouro("Rua nome da rua");
		entregador.setNumeroEndereco(55L);
		entregador.setComplementoEndereco("");
		entregador.setCep("04455310");
		
		Assertions.assertThrows(BusinessException.class,() -> this.controller.create(entregador));

    }
	
	@Test
    public void testEntregadorControllerErroNumeroContaCorrente() {

		EntregadorDTO entregador = new EntregadorDTO();
		entregador.setNome("Maria Joaquina");
		entregador.setCpf("44568600065");
		entregador.setRg("3520374");
		entregador.setEmail("emaildeteste@gmail.com");
		entregador.setBancoNome("Santander");
		entregador.setBanco("0033");
		entregador.setBancoCNPJ("16407431000107");
		entregador.setAgencia("00001");
		entregador.setConta("00000a001");
		entregador.setDigitoConta(0);
		entregador.setTipoConta(TipoContaEnum.CORRENTE);
		entregador.setChave("thiagotobias@gmail.com");
		entregador.setUfCNH("SP");
		entregador.setNumeroCNH(71662410467L);
		entregador.setCategoriaCNH("B");
		entregador.setDataVencimentoCNH(LocalDate.of(2025, 12, 30) );
		entregador.setDataEmisssaoCNH(LocalDate.of(2020, 12, 30));
		entregador.setTamanhoCamisa("");
		entregador.setTipoVeiculoEnum(TipoVeiculoEnum.CARRO);
		entregador.setMarcaVeiculo("");
		entregador.setPlacaVeiculo("ABC1A44");
		entregador.setCorVeiculo("");
		entregador.setRenavam(11457286143L);
		entregador.setAnoVeiculo(2010);
		entregador.setLogradouro("Rua nome da rua");
		entregador.setNumeroEndereco(55L);
		entregador.setComplementoEndereco("");
		entregador.setCep("04455310");
		
		Assertions.assertThrows(BusinessException.class,() -> this.controller.create(entregador));

    }
	
	@Test
    public void testEntregadorControllerErroBanco() {

		EntregadorDTO entregador = new EntregadorDTO();
		entregador.setNome("Maria Joaquina");
		entregador.setCpf("44568600065");
		entregador.setRg("3520374");
		entregador.setEmail("emaildeteste@gmail.com");
		entregador.setBancoNome("Santander");
		entregador.setBanco("0A33");
		entregador.setBancoCNPJ("16407431000107");
		entregador.setAgencia("00001");
		entregador.setConta("00000001");
		entregador.setDigitoConta(0);
		entregador.setTipoConta(TipoContaEnum.CORRENTE);
		entregador.setChave("thiagotobias@gmail.com");
		entregador.setUfCNH("SP");
		entregador.setNumeroCNH(71662410467L);
		entregador.setCategoriaCNH("B");
		entregador.setDataVencimentoCNH(LocalDate.of(2025, 12, 30) );
		entregador.setDataEmisssaoCNH(LocalDate.of(2020, 12, 30));
		entregador.setTamanhoCamisa("");
		entregador.setTipoVeiculoEnum(TipoVeiculoEnum.CARRO);
		entregador.setMarcaVeiculo("");
		entregador.setPlacaVeiculo("ABC1A44");
		entregador.setCorVeiculo("");
		entregador.setRenavam(11457286143L);
		entregador.setAnoVeiculo(2010);
		entregador.setLogradouro("Rua nome da rua");
		entregador.setNumeroEndereco(55L);
		entregador.setComplementoEndereco("");
		entregador.setCep("04455310");
		
		Assertions.assertThrows(BusinessException.class,() -> this.controller.create(entregador));

    }
	
	@Test
    public void testEntregadorControllerValidarDataModelo() {

		EntregadorDTO entregador = new EntregadorDTO();
		entregador.setNome("Maria Joaquina");
		entregador.setCpf("44568600065");
		entregador.setRg("3520374");
		entregador.setEmail("emaildeteste@gmail.com");
		entregador.setBancoNome("Santander");
		entregador.setBanco("0033");
		entregador.setBancoCNPJ("16407431000107");
		entregador.setAgencia("00001");
		entregador.setConta("00000001");
		entregador.setDigitoConta(0);
		entregador.setTipoConta(TipoContaEnum.CORRENTE);
		entregador.setChave("thiagotobias@gmail.com");
		entregador.setUfCNH("SP");
		entregador.setNumeroCNH(71662410467L);
		entregador.setCategoriaCNH("B");
		entregador.setDataVencimentoCNH(LocalDate.of(2025, 12, 30) );
		entregador.setDataEmisssaoCNH(LocalDate.of(2020, 12, 30));
		entregador.setTamanhoCamisa("");
		entregador.setTipoVeiculoEnum(TipoVeiculoEnum.CARRO);
		entregador.setMarcaVeiculo("");
		entregador.setPlacaVeiculo("ABC1A44");
		entregador.setCorVeiculo("");
		entregador.setRenavam(11457286143L);
		entregador.setAnoVeiculo(2000);
		entregador.setLogradouro("Rua nome da rua");
		entregador.setNumeroEndereco(55L);
		entregador.setComplementoEndereco("");
		entregador.setCep("04455310");
		
		Assertions.assertThrows(BusinessException.class,() -> this.controller.create(entregador));

    }
	
	
	@Test
    public void testEntregadorControllerValidarPlacaVeiculo() {

		EntregadorDTO entregador = new EntregadorDTO();
		entregador.setNome("Maria Joaquina");
		entregador.setCpf("44568600065");
		entregador.setRg("3520374");
		entregador.setEmail("emaildeteste@gmail.com");
		entregador.setBancoNome("Santander");
		entregador.setBanco("0033");
		entregador.setBancoCNPJ("16407431000107");
		entregador.setAgencia("00001");
		entregador.setConta("00000001");
		entregador.setDigitoConta(0);
		entregador.setTipoConta(TipoContaEnum.CORRENTE);
		entregador.setChave("thiagotobias@gmail.com");
		entregador.setUfCNH("SP");
		entregador.setNumeroCNH(71662410467L);
		entregador.setCategoriaCNH("B");
		entregador.setDataVencimentoCNH(LocalDate.of(2025, 12, 30) );
		entregador.setDataEmisssaoCNH(LocalDate.of(2020, 12, 30));
		entregador.setTamanhoCamisa("");
		entregador.setTipoVeiculoEnum(TipoVeiculoEnum.CARRO);
		entregador.setMarcaVeiculo("");
		entregador.setPlacaVeiculo("ABCAA44");
		entregador.setCorVeiculo("");
		entregador.setRenavam(11457286143L);
		entregador.setAnoVeiculo(2010);
		entregador.setLogradouro("Rua nome da rua");
		entregador.setNumeroEndereco(55L);
		entregador.setComplementoEndereco("");
		entregador.setCep("04455310");
		
		Assertions.assertThrows(BusinessException.class,() -> this.controller.create(entregador));

    }
	
	@Test
    public void testEntregadorControllerValidaRenavam() {

		EntregadorDTO entregador = new EntregadorDTO();
		entregador.setNome("Maria Joaquina");
		entregador.setCpf("44568600065");
		entregador.setRg("3520374");
		entregador.setEmail("emaildeteste@gmail.com");
		entregador.setBancoNome("Santander");
		entregador.setBanco("0033");
		entregador.setBancoCNPJ("16407431000107");
		entregador.setAgencia("00001");
		entregador.setConta("00000001");
		entregador.setDigitoConta(0);
		entregador.setTipoConta(TipoContaEnum.CORRENTE);
		entregador.setChave("thiagotobias@gmail.com");
		entregador.setUfCNH("SP");
		entregador.setNumeroCNH(71662410467L);
		entregador.setCategoriaCNH("B");
		entregador.setDataVencimentoCNH(LocalDate.of(2025, 12, 30) );
		entregador.setDataEmisssaoCNH(LocalDate.of(2020, 12, 30));
		entregador.setTamanhoCamisa("");
		entregador.setTipoVeiculoEnum(TipoVeiculoEnum.CARRO);
		entregador.setMarcaVeiculo("");
		entregador.setPlacaVeiculo("ABC1A44");
		entregador.setCorVeiculo("");
		entregador.setRenavam(114572861443L);
		entregador.setAnoVeiculo(2010);
		entregador.setLogradouro("Rua nome da rua");
		entregador.setNumeroEndereco(55L);
		entregador.setComplementoEndereco("");
		entregador.setCep("04455310");
		
		Assertions.assertThrows(BusinessException.class,() -> this.controller.create(entregador));

    }
	
	@Test
    public void testEntregadorControllerValidaRenavam2() {

		EntregadorDTO entregador = new EntregadorDTO();
		entregador.setNome("Maria Joaquina");
		entregador.setCpf("44568600065");
		entregador.setRg("3520374");
		entregador.setEmail("emaildeteste@gmail.com");
		entregador.setBancoNome("Santander");
		entregador.setBanco("0033");
		entregador.setBancoCNPJ("16407431000107");
		entregador.setAgencia("00001");
		entregador.setConta("00000001");
		entregador.setDigitoConta(0);
		entregador.setTipoConta(TipoContaEnum.CORRENTE);
		entregador.setChave("thiagotobias@gmail.com");
		entregador.setUfCNH("SP");
		entregador.setNumeroCNH(71662410467L);
		entregador.setCategoriaCNH("B");
		entregador.setDataVencimentoCNH(LocalDate.of(2025, 12, 30) );
		entregador.setDataEmisssaoCNH(LocalDate.of(2020, 12, 30));
		entregador.setTamanhoCamisa("");
		entregador.setTipoVeiculoEnum(TipoVeiculoEnum.CARRO);
		entregador.setMarcaVeiculo("");
		entregador.setPlacaVeiculo("ABC1A44");
		entregador.setCorVeiculo("");
		entregador.setRenavam(11472861443L);
		entregador.setAnoVeiculo(2010);
		entregador.setLogradouro("Rua nome da rua");
		entregador.setNumeroEndereco(55L);
		entregador.setComplementoEndereco("");
		entregador.setCep("04455310");
		
		Assertions.assertThrows(BusinessException.class,() -> this.controller.create(entregador));

    }

	@Test
    public void testEntregadorControllerValidarCNH() {

		EntregadorDTO entregador = new EntregadorDTO();
		entregador.setNome("Maria Joaquina");
		entregador.setCpf("44568600065");
		entregador.setRg("3520374");
		entregador.setEmail("emaildeteste@gmail.com");
		entregador.setBancoNome("Santander");
		entregador.setBanco("0033");
		entregador.setBancoCNPJ("16407431000107");
		entregador.setAgencia("00001");
		entregador.setConta("00000001");
		entregador.setDigitoConta(0);
		entregador.setTipoConta(TipoContaEnum.CORRENTE);
		entregador.setChave("thiagotobias@gmail.com");
		entregador.setUfCNH("SP");
		entregador.setNumeroCNH(71662410467L);
		entregador.setCategoriaCNH("B");
		entregador.setDataVencimentoCNH(LocalDate.of(2022, 12, 30) );
		entregador.setDataEmisssaoCNH(LocalDate.of(2020, 12, 30));
		entregador.setTamanhoCamisa("");
		entregador.setTipoVeiculoEnum(TipoVeiculoEnum.CARRO);
		entregador.setMarcaVeiculo("");
		entregador.setPlacaVeiculo("ABC1A44");
		entregador.setCorVeiculo("");
		entregador.setRenavam(11457286143L);
		entregador.setAnoVeiculo(2010);
		entregador.setLogradouro("Rua nome da rua");
		entregador.setNumeroEndereco(55L);
		entregador.setComplementoEndereco("");
		entregador.setCep("04455310");
		
		Assertions.assertThrows(BusinessException.class,() -> this.controller.create(entregador));

    }
	
	@Test
    public void testEntregadorControllerValidarTipoVeiculo() {

		EntregadorDTO entregador = new EntregadorDTO();
		entregador.setNome("Maria Joaquina");
		entregador.setCpf("44568600065");
		entregador.setRg("3520374");
		entregador.setEmail("emaildeteste@gmail.com");
		entregador.setBancoNome("Santander");
		entregador.setBanco("0033");
		entregador.setBancoCNPJ("16407431000107");
		entregador.setAgencia("00001");
		entregador.setConta("00000001");
		entregador.setDigitoConta(0);
		entregador.setTipoConta(TipoContaEnum.CORRENTE);
		entregador.setChave("thiagotobias@gmail.com");
		entregador.setUfCNH("SP");
		entregador.setNumeroCNH(71662410467L);
		entregador.setCategoriaCNH("A");
		entregador.setDataVencimentoCNH(LocalDate.of(2025, 12, 30) );
		entregador.setDataEmisssaoCNH(LocalDate.of(2020, 12, 30));
		entregador.setTamanhoCamisa("");
		entregador.setTipoVeiculoEnum(TipoVeiculoEnum.CARRO);
		entregador.setMarcaVeiculo("");
		entregador.setPlacaVeiculo("ABC1A44");
		entregador.setCorVeiculo("");
		entregador.setRenavam(11457286143L);
		entregador.setAnoVeiculo(2010);
		entregador.setLogradouro("Rua nome da rua");
		entregador.setNumeroEndereco(55L);
		entregador.setComplementoEndereco("");
		entregador.setCep("04455310");
		
		Assertions.assertThrows(BusinessException.class,() -> this.controller.create(entregador));

    }

}
