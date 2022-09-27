package br.com.financeiro.repository;

import br.com.financeiro.model.TipoDespesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TipoDespesaRepository extends JpaRepository<TipoDespesa, Long> {

    @Query(value = "select * from tipodespesa where upper(nome) = upper(:nome) or upper(descricao) = upper(:descricao)", nativeQuery = true)
    List<TipoDespesa> findByNomeDescricao(String nome, String descricao );
}
