package br.com.ifomeadaf1rst.service;

import java.util.List;
import java.util.UUID;

import br.com.ifomeadaf1rst.dto.EntregadorDTO;

public interface EntregadorService {

	EntregadorDTO create(EntregadorDTO entregador);

	EntregadorDTO readById(UUID id);

	List<EntregadorDTO> readAll();

	EntregadorDTO update(EntregadorDTO entregador, UUID id);

	void delete(UUID id);

}
