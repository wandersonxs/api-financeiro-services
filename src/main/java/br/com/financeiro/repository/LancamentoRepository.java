package br.com.financeiro.repository;

import br.com.financeiro.model.Lancamento;
import br.com.financeiro.model.Situacao;
import br.com.financeiro.model.TipoDespesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {


}
