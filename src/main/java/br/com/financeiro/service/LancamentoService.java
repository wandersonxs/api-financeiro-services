package br.com.financeiro.service;

import br.com.financeiro.dto.LancamentoRequestDto;
import br.com.financeiro.dto.LancamentoResponseDto;
import br.com.financeiro.model.Lancamento;

import java.util.List;

public interface LancamentoService {

    List<Lancamento> getTodosLancamentos();

    LancamentoResponseDto addLancamento(LancamentoRequestDto lancamentoRequestDto);


}
