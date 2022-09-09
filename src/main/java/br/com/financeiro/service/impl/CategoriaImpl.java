package br.com.financeiro.service.impl;

import br.com.financeiro.dto.CategoriaRequestDto;
import br.com.financeiro.dto.CategoriaResponseDto;
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

    @Override
    public CategoriaResponseDto addCategoria(CategoriaRequestDto categoriaRequestDto) {
        CategoriaResponseDto categoriaResponseDto = new CategoriaResponseDto();

        Categoria categoria = new Categoria();
        categoria.setNome(categoriaRequestDto.getNome());
        categoria.setDescricao(categoriaRequestDto.getDescricao());

        Categoria categoriaSaved = categoriaRepository.save(categoria);

        categoriaResponseDto.setId(categoriaSaved.getId());
        categoriaResponseDto.setNome(categoriaSaved.getNome());
        categoriaResponseDto.setDescricao(categoriaSaved.getDescricao());

        return categoriaResponseDto;
    }


}
