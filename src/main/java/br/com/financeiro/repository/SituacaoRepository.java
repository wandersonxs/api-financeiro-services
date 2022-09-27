package br.com.financeiro.repository;


import br.com.financeiro.model.Categoria;
import br.com.financeiro.model.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SituacaoRepository extends JpaRepository<Situacao, Long> {

    @Query(value = "select * from situacao where upper(nome) = upper(:nome) or upper(descricao) = upper(:descricao)", nativeQuery = true)
    List<Situacao> findByNomeDescricao(String nome, String descricao );
}
