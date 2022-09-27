package br.com.financeiro.repository;


import br.com.financeiro.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query(value = "select * from categorias where upper(nome) = upper(:nome) or upper(descricao) = upper(:descricao)", nativeQuery = true)
    List<Categoria> findByNomeDescricao(String nome, String descricao );

}
