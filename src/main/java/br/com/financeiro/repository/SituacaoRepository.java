package br.com.financeiro.repository;


import br.com.financeiro.model.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SituacaoRepository extends JpaRepository<Situacao, Long> {
}
