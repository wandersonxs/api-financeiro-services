package br.com.financeiro.service.impl;

import br.com.financeiro.dto.LancamentoRequestDto;
import br.com.financeiro.dto.LancamentoResponseDto;
import br.com.financeiro.model.Lancamento;
import br.com.financeiro.repository.LancamentoRepository;
import br.com.financeiro.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoImpl implements LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Override
    public List<Lancamento> getTodosLancamentos() {
        return lancamentoRepository.findAll();
    }

    public LancamentoResponseDto addLancamento(LancamentoRequestDto lancamentoRequestDto) {

        Lancamento lancamento = new Lancamento();
        lancamento.setNome(lancamentoRequestDto.getNome());
        lancamento.setDescricao(lancamentoRequestDto.getDescricao());

        Lancamento lancamentoSaved = lancamentoRepository.save(lancamento);

        LancamentoResponseDto lancamentoResponseDto = new LancamentoResponseDto();
        lancamentoResponseDto.setId(lancamentoSaved.getId());
        lancamentoResponseDto.setNome(lancamentoSaved.getNome());
        lancamentoResponseDto.setDescricao(lancamentoSaved.getDescricao());

        return lancamentoResponseDto;

    }

    public LancamentoResponseDto updateLancamento(Long id, LancamentoRequestDto lancamentoRequestDto) {

        Lancamento lancamento = lancamentoRepository.findById(id).get();
        lancamento.setNome(lancamentoRequestDto.getNome());
        lancamento.setDescricao(lancamentoRequestDto.getDescricao());

        Lancamento lancamentoSaved = lancamentoRepository.save(lancamento);

        LancamentoResponseDto lancamentoResponseDto = new LancamentoResponseDto();
        lancamentoResponseDto.setId(lancamentoSaved.getId());
        lancamentoResponseDto.setNome(lancamentoSaved.getNome());
        lancamentoResponseDto.setDescricao(lancamentoSaved.getDescricao());

        return lancamentoResponseDto;

    }

}
