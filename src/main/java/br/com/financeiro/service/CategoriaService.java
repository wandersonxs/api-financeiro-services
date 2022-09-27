package br.com.financeiro.service;

import br.com.financeiro.dto.CategoriaRequestDto;
import br.com.financeiro.dto.CategoriaResponseDto;
import br.com.financeiro.model.Categoria;

import java.util.List;


public interface CategoriaService {

    List<Categoria> getTodasCategorias();

    CategoriaResponseDto addCategoria(CategoriaRequestDto categoriaRequestDto);

    CategoriaResponseDto updateCategoria(Long id, CategoriaRequestDto categoriaRequestDto);

    CategoriaResponseDto getCategoriaById(Long id);

    void deleteCategoriaById(Long id);

    List<Categoria> getCategoriasByFilter(String nome, String descricao);

}
