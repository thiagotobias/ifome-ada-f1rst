package br.com.ifomeadaf1rst.service;

import java.util.List;
import java.util.UUID;

import br.com.ifomeadaf1rst.dto.EntregadorDTO;

public interface EntregadorService {

	public EntregadorDTO create(EntregadorDTO entregador);

	public EntregadorDTO readById(UUID id);

	public List<EntregadorDTO> readAll();

	public EntregadorDTO update(EntregadorDTO entregador, UUID id);

	public void delete(UUID id);

}
