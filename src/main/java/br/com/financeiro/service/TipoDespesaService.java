package br.com.financeiro.service;

import br.com.financeiro.dto.TipoDespesaRequestDto;
import br.com.financeiro.dto.TipoDespesaResponseDto;
import br.com.financeiro.model.Situacao;
import br.com.financeiro.model.TipoDespesa;

import java.util.List;

public interface TipoDespesaService {

    List<TipoDespesa> getTodosTiposDespesas();

    TipoDespesaResponseDto addTipoDespesa(TipoDespesaRequestDto tipoDespesaRequestDto);

    TipoDespesaResponseDto updateTipoDespesa(Long id, TipoDespesaRequestDto tipoDespesaRequestDto);

    TipoDespesaResponseDto getByIdTipoDespesa(Long id);

    void deleteTipoDespesa(Long id);

    List<TipoDespesa> getTipoDespesaByFilter(String nome, String descricao);
}
