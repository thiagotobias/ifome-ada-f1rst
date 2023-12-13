package br.com.ifomeadaf1rst.dto.mapper;

import br.com.ifomeadaf1rst.dto.EntregadorDTO;
import br.com.ifomeadaf1rst.model.Entregador;
import org.mapstruct.Mapper;

@Mapper
public interface EntregadorMapper {
    EntregadorDTO toDTO(Entregador entregador);
}
