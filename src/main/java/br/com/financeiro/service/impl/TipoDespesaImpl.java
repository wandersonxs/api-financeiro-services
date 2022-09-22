package br.com.financeiro.service.impl;

import br.com.financeiro.dto.TipoDespesaRequestDto;
import br.com.financeiro.dto.TipoDespesaResponseDto;
import br.com.financeiro.model.TipoDespesa;
import br.com.financeiro.repository.TipoDespesaRepository;
import br.com.financeiro.service.TipoDespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDespesaImpl implements TipoDespesaService {

    @Autowired
    private TipoDespesaRepository tipoDespesaRepository;

    public List<TipoDespesa> getTodosTiposDespesas() {
        return tipoDespesaRepository.findAll();
    }

    public TipoDespesaResponseDto addTipoDespesa(TipoDespesaRequestDto tipoDespesaRequestDto) {

        TipoDespesa tipoDespesa = new TipoDespesa();

        tipoDespesa.setNome(tipoDespesaRequestDto.getNome());
        tipoDespesa.setDescricao(tipoDespesaRequestDto.getDescricao());

        TipoDespesa tipoDespesaSaved = tipoDespesaRepository.save(tipoDespesa);

        TipoDespesaResponseDto tipoDespesaResponseDto = new TipoDespesaResponseDto();

        tipoDespesaResponseDto.setId(tipoDespesaSaved.getId());
        tipoDespesaResponseDto.setNome(tipoDespesaSaved.getNome());
        tipoDespesaResponseDto.setDescricao(tipoDespesaSaved.getDescricao());

        return tipoDespesaResponseDto;

    }

    public TipoDespesaResponseDto updateTipoDespesa(Long id, TipoDespesaRequestDto tipoDespesaRequestDto) {

        TipoDespesa tipoDespesa = tipoDespesaRepository.findById(id).get();

        tipoDespesa.setNome(tipoDespesaRequestDto.getNome());
        tipoDespesa.setDescricao(tipoDespesaRequestDto.getDescricao());

        TipoDespesa tipoDespesaSaved = tipoDespesaRepository.save(tipoDespesa);

        TipoDespesaResponseDto tipoDespesaResponseDto = new TipoDespesaResponseDto();

        tipoDespesaResponseDto.setId(tipoDespesaSaved.getId());
        tipoDespesaResponseDto.setNome(tipoDespesaSaved.getNome());
        tipoDespesaResponseDto.setDescricao(tipoDespesaSaved.getDescricao());

        return tipoDespesaResponseDto;

    }

    public TipoDespesaResponseDto getByIdTipoDespesa(Long id) {

        TipoDespesaResponseDto tipoDespesaResponseDto = new TipoDespesaResponseDto();
        Optional<TipoDespesa> tipoDespesa = tipoDespesaRepository.findById(id);

        if (tipoDespesa.isPresent()) {

            tipoDespesaResponseDto.setId(tipoDespesa.get().getId());
            tipoDespesaResponseDto.setNome(tipoDespesa.get().getNome());
            tipoDespesaResponseDto.setDescricao(tipoDespesa.get().getDescricao());

        }

        return tipoDespesaResponseDto;

    }

    public void deleteTipoDespesa(Long id) {

        tipoDespesaRepository.deleteById(id);

    }

}
