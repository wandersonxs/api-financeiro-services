package br.com.financeiro.service.impl;

import br.com.financeiro.dto.LancamentoRequestDto;
import br.com.financeiro.dto.LancamentoResponseDto;
import br.com.financeiro.model.Lancamento;
import br.com.financeiro.repository.LancamentoRepository;
import br.com.financeiro.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

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
        lancamento.setTipoDespesa(lancamentoRequestDto.getTipo_Despesa_fk());
        lancamento.setValor(lancamentoRequestDto.getValor());
        lancamento.setData(lancamentoRequestDto.getData());
        lancamento.setSituacao(lancamentoRequestDto.getSituacao_fk());
        lancamento.setCategoria(lancamentoRequestDto.getCategoria_fk());

        Lancamento lancamentoSaved = lancamentoRepository.save(lancamento);

        LancamentoResponseDto lancamentoResponseDto = new LancamentoResponseDto();
        lancamentoResponseDto.setId(lancamentoSaved.getId());
        lancamentoResponseDto.setNome(lancamentoSaved.getNome());
        lancamentoResponseDto.setDescricao(lancamentoSaved.getDescricao());
        lancamentoResponseDto.setTipo_Despesa_fk(lancamentoSaved.getTipoDespesa());
        lancamentoResponseDto.setValor(lancamentoSaved.getValor());
        lancamentoResponseDto.setData(lancamentoSaved.getData());
        lancamentoResponseDto.setCategoria_fk(lancamentoSaved.getCategoria());
        lancamentoResponseDto.setSituacao_fk(lancamentoSaved.getSituacao());

        return lancamentoResponseDto;

    }

    public LancamentoResponseDto updateLancamento(Long id, LancamentoRequestDto lancamentoRequestDto) {

        Date oldDate = new Date(lancamentoRequestDto.getData().getTime());

        Lancamento lancamento = lancamentoRepository.findById(id).get();

        lancamento.setNome(lancamentoRequestDto.getNome());
        lancamento.setDescricao(lancamentoRequestDto.getDescricao());
        lancamento.setTipoDespesa(lancamentoRequestDto.getTipo_Despesa_fk());
        lancamento.setValor(lancamentoRequestDto.getValor());
        lancamento.setData(oldDate);
        lancamento.setCategoria(lancamentoRequestDto.getCategoria_fk());
        lancamento.setSituacao(lancamentoRequestDto.getSituacao_fk());

        Lancamento lancamentoSaved = lancamentoRepository.save(lancamento);

        LancamentoResponseDto lancamentoResponseDto = new LancamentoResponseDto();
        lancamentoResponseDto.setId(lancamentoSaved.getId());
        lancamentoResponseDto.setNome(lancamentoSaved.getNome());
        lancamentoResponseDto.setDescricao(lancamentoSaved.getDescricao());
        lancamentoResponseDto.setTipo_Despesa_fk(lancamentoSaved.getTipoDespesa());
        lancamentoResponseDto.setValor(lancamentoSaved.getValor());
        lancamentoResponseDto.setData(lancamentoSaved.getData());
        lancamentoResponseDto.setCategoria_fk(lancamentoSaved.getCategoria());
        lancamentoResponseDto.setSituacao_fk(lancamentoSaved.getSituacao());

        return lancamentoResponseDto;

    }

    public LancamentoResponseDto getByIdLancamento(Long id) {

        LancamentoResponseDto lancamentoResponseDto = new LancamentoResponseDto();
        Optional<Lancamento> lancamento = lancamentoRepository.findById(id);

        if (lancamento.isPresent()) {

            lancamentoResponseDto.setId(lancamento.get().getId());
            lancamentoResponseDto.setNome(lancamento.get().getNome());
            lancamentoResponseDto.setDescricao(lancamento.get().getDescricao());
            lancamentoResponseDto.setTipo_Despesa_fk(lancamento.get().getTipoDespesa());
            lancamentoResponseDto.setValor(lancamento.get().getValor());
            lancamentoResponseDto.setData(lancamento.get().getData());
            lancamentoResponseDto.setSituacao_fk(lancamento.get().getSituacao());
            lancamentoResponseDto.setCategoria_fk(lancamento.get().getCategoria());
        }

        return lancamentoResponseDto;

    }

    public void deleteLancamento(Long id) {

        lancamentoRepository.deleteById(id);

    }

}
