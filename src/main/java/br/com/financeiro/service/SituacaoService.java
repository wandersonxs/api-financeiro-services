package br.com.financeiro.service;

import br.com.financeiro.dto.SituacaoRequestDto;
import br.com.financeiro.dto.SituacaoResponseDto;
import br.com.financeiro.model.Situacao;

import java.util.List;

public interface SituacaoService {

    List<Situacao> getTodasSituacoes();

    SituacaoResponseDto addSituacao(SituacaoRequestDto situacaoRequestDto);

    SituacaoResponseDto updateSituacao(Long id, SituacaoRequestDto situacaoRequestDto);

    SituacaoResponseDto getByIdSituacao(Long id);

    void deleteSituacao(Long id);

}
