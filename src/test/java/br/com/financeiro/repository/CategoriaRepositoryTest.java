package br.com.financeiro.repository;

import br.com.financeiro.model.Categoria;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoriaRepositoryTest {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Test
    public void testCategoriasFindAll(){
        List<Categoria> categorias = categoriaRepository.findAll();

        categorias.forEach(n -> {
            System.out.println(n.getId() + " " + n.getNome() + " " + n.getDescricao());
        });

        assertNotNull(categorias);
    }

    @Test
    public void testIncluirCategoria(){

        Categoria categoria = new Categoria();
        categoria.setNome("Estudo");
        categoria.setDescricao("Despesa com estudos");
        Categoria categoriaSalva = categoriaRepository.save(categoria);

        System.out.println(categoriaSalva.getId());

        assertNotNull(categoriaSalva.getId());
        assertEquals(categoria.getNome(), categoriaSalva.getNome());
    }


}
