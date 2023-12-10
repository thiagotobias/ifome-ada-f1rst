package br.com.ifomeadaf1rst.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.ifomeadaf1rst.dto.EntregadorDTO;
import br.com.ifomeadaf1rst.enums.TipoVeiculoEnum;
import br.com.ifomeadaf1rst.exception.BusinessException;
import br.com.ifomeadaf1rst.service.EntregadorService;

@Service
public class EntregadorServiceImpl implements EntregadorService {

	@Override
	public EntregadorDTO create(EntregadorDTO entregador) {

		validarDocumentoCNH(entregador);

		return null;
	}

	private void validarDocumentoCNH(EntregadorDTO entregador) {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataVencimento = entregador.getDataVencimentoDocumento().toInstant().atZone(ZoneId.systemDefault())
				.toLocalDate();
		if (dataVencimento.isBefore(dataAtual)) {
			throw new BusinessException("A CNH está vencida. Não é permitido continuar com uma CNH vencida.");
		}

		// Obtém as categorias do condutor e do veículo
		TipoVeiculoEnum categoriaCNH = TipoVeiculoEnum.valueOf(entregador.getCategoriaDocumento());
		TipoVeiculoEnum categoriaVeiculo = entregador.getTipoVeiculoEnum();

		// Verifica se a categoria da CNH condiz com a categoria do veículo
		if (!categoriaCNH.getTipoVeiculoEnum().equals(categoriaVeiculo)) {
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
