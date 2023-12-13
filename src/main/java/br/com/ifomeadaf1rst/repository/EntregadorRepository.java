package br.com.ifomeadaf1rst.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifomeadaf1rst.model.Entregador;

import java.util.UUID;

public interface EntregadorRepository extends JpaRepository<Entregador, UUID> {

}
