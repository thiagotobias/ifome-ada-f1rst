package br.com.ifomeadaf1rst.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifomeadaf1rst.dto.EntregadorDTO;
import br.com.ifomeadaf1rst.enums.TipoVeiculoEnum;
import br.com.ifomeadaf1rst.exception.BusinessException;
import br.com.ifomeadaf1rst.model.Entregador;
import br.com.ifomeadaf1rst.repository.EntregadorRepository;
import br.com.ifomeadaf1rst.service.EntregadorService;

@Service
public class EntregadorServiceImpl implements EntregadorService {
	
	@Autowired
	private EntregadorRepository repEntregador;

	@Override
	public EntregadorDTO create(EntregadorDTO entregador) {

		validarCNH(entregador);
		validaVeiculo(entregador);
		validarContaBancaria(entregador);
		
		Entregador entregadorRep = repEntregador.save( montaEntregador(entregador));
		entregador.setId(entregadorRep.getId());
		
		return entregador;
	}

	private Entregador montaEntregador(EntregadorDTO entregador) {
		Entregador entregadorRep = new Entregador();
		entregadorRep.setNome(entregador.getNome());
		entregadorRep.setCpf(entregador.getCpf());
		entregadorRep.setEmail(entregador.getEmail());
		entregadorRep.setRg(entregador.getRg());
		entregadorRep.setTamanhoCamisa(entregador.getTamanhoCamisa());
//		entregadorRep.setDadosBancariosId(); //
//		entregadorRep.setDocumentoId(); //
//		entregadorRep.setEnderecoId();//
//		entregadorRep.setVeiculoId();//
		
		return entregadorRep;
	}

	public void validarContaBancaria(EntregadorDTO entregador) {
		validarNumeroAgencia(entregador.getAgencia());
		validarNumeroConta(entregador.getConta());
		validarInstituicaoBancaria(entregador.getBanco());
	}

	private void validarNumeroAgencia(String numeroAgencia) {
		String regex = "^[0-9]{5}$";
		if (!Pattern.matches(regex, numeroAgencia)) {
			throw new BusinessException("O número da agência inválido!");
		}
	}

	private void validarNumeroConta(String numeroConta) {
        String regex = "^[0-9]{8}$";
        if (!Pattern.matches(regex, numeroConta)) {
            throw new BusinessException("O número da conta corrente inválido!");
        }
	}

	private void validarInstituicaoBancaria(String instituicaoBancaria) {
		String regex = "^[0-9]{4}$";
        if (!Pattern.matches(regex, instituicaoBancaria)) {
            throw new BusinessException("O número da instituição bancária inválido!");
        }
	}

	private void validaVeiculo(EntregadorDTO entregador) {
		validarDataModelo(entregador.getAnoVeiculo());
		validarPlacaVeiculo(entregador.getPlacaVeiculo());
		validaRenavam(entregador.getRenavam());
	}

	private void validarDataModelo(Integer anoVeiculo) {
		if (anoVeiculo < 2010) {
			throw new BusinessException("A data do modelo do veículo não pode ser inferior a 2010.");
		}
	}

	private void validarPlacaVeiculo(String placaVeiculo) {
		String regexNormal = "^[A-Z]{3}[0-9]{4}$";
		String regexMercosul = "^[A-Z]{3}[0-9][A-Z][0-9]{2}$";
		if (!placaVeiculo.matches(regexNormal) && !placaVeiculo.matches(regexMercosul)) {
			throw new BusinessException("A placa do veículo não segue o padrão estabelecido.");
		}
	}

	public void validaRenavam(Long renavamLong) {
		String renavam = renavamLong.toString();

		if (renavam.matches("^([0-9]{9})$")) {
			renavam = "00" + renavam;
		}

		if (!renavam.matches("[0-9]{11}")) {
			throw new BusinessException("Renavam inválido!");
		}

		String renavamSemDigito = renavam.substring(0, 10);
		String renavamReversoSemDigito = new StringBuilder(renavamSemDigito).reverse().toString();

		int soma = 0;

		for (int i = 0; i < 8; i++) {
			int algarismo = Integer.parseInt(renavamReversoSemDigito.substring(i, i + 1));
			int multiplicador = i + 2;
			soma += algarismo * multiplicador;
		}

		soma += Character.getNumericValue(renavamReversoSemDigito.charAt(8)) * 2;
		soma += Character.getNumericValue(renavamReversoSemDigito.charAt(9)) * 3;

		int mod11 = soma % 11;
		int ultimoDigitoCalculado = 11 - mod11;
		ultimoDigitoCalculado = (ultimoDigitoCalculado >= 10) ? 0 : ultimoDigitoCalculado;

		int digitoRealInformado = Integer.parseInt(renavam.substring(renavam.length() - 1));

		if (ultimoDigitoCalculado != digitoRealInformado) {
			throw new BusinessException("Renavam inválido!");
		}

	}

	private void validarCNH(EntregadorDTO entregador) {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataVencimento = entregador.getDataVencimentoCNH().toInstant().atZone(ZoneId.systemDefault())
				.toLocalDate();

		if (dataVencimento.isBefore(dataAtual)) {
			throw new BusinessException("A CNH está vencida. Não é permitido continuar com uma CNH vencida.");
		}

		TipoVeiculoEnum categoriaCNH = TipoVeiculoEnum.fromString(entregador.getCategoriaCNH());
		if (!categoriaCNH.equals(entregador.getTipoVeiculoEnum())) {
			throw new BusinessException("Categoria da CNH do condutor não condiz com o veículo informado");
		}

	}

	@Override
	public EntregadorDTO readById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntregadorDTO> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntregadorDTO update(EntregadorDTO entregador, UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub

	}

}
