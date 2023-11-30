package br.com.ifomeadaf1rst.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifomeadaf1rst.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
