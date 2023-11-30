package br.com.ifomeadaf1rst.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifomeadaf1rst.model.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {

}
