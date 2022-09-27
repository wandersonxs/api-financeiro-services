package br.com.financeiro.repository;

import br.com.financeiro.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

    @Query(value = "select * from lancamentos where upper(nome) = upper(:nome) or upper(descricao) = upper(:descricao)" +
            "or valor = :valor or data = :data", nativeQuery = true)
    List<Lancamento> findByNomeDescricaoValor(String nome, String descricao, Double valor, Date data);

}
