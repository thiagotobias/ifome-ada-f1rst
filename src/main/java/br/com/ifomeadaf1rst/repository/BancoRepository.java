package br.com.ifomeadaf1rst.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifomeadaf1rst.model.Banco;

public interface BancoRepository extends JpaRepository<Banco, Long> {

}
