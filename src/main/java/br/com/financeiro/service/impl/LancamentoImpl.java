package br.com.financeiro.service.impl;

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


}
