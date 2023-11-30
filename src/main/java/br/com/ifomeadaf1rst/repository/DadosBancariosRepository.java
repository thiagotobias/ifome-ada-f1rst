package br.com.ifomeadaf1rst.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifomeadaf1rst.model.DadosBancarios;

public interface DadosBancariosRepository extends JpaRepository<DadosBancarios, Long> {

}
