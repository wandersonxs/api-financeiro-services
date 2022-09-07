package br.com.financeiro.service.impl;

import br.com.financeiro.model.Categoria;
import br.com.financeiro.repository.CategoriaRepository;
import br.com.financeiro.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> getTodasCategorias() {
        return categoriaRepository.findAll();
    }
}
