package br.com.financeiro.controller;


import br.com.financeiro.dto.CategoriaRequestDto;
import br.com.financeiro.dto.CategoriaResponseDto;
import br.com.financeiro.model.Categoria;
import br.com.financeiro.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(value = "/categorias", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Categoria>> getCategorias() {

        List<Categoria> categorias = categoriaService.getTodasCategorias();
        return ResponseEntity.ok(categorias);

    }

    @RequestMapping(value = "/categorias", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoriaResponseDto> addCategoria(@RequestBody CategoriaRequestDto categoriaRequestDto) {

        CategoriaResponseDto categoriaResponseDto = categoriaService.addCategoria(categoriaRequestDto);
        return new ResponseEntity(categoriaResponseDto, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/categorias/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoriaResponseDto> updateCategoria(@PathVariable(name = "id") Long id, @RequestBody CategoriaRequestDto categoriaRequestDto) {

        CategoriaResponseDto categoriaResponseDto = categoriaService.updateCategoria(id, categoriaRequestDto);
        return new ResponseEntity(categoriaResponseDto, HttpStatus.OK);

    }

    @RequestMapping(value = "/categorias/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoriaResponseDto> getCategoriaById(@PathVariable(name = "id") Long id) {

        CategoriaResponseDto categoriaResponseDto = categoriaService.getCategoriaById(id);
        return new ResponseEntity(categoriaResponseDto, HttpStatus.OK);

    }

    @RequestMapping(value = "/categorias/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteCategoriaById(@PathVariable(name = "id") Long id) {

        categoriaService.deleteCategoriaById(id);
        return new ResponseEntity("EXCLUÍDO COM SUCESSO", HttpStatus.OK);

    }

    @RequestMapping(value = "/categorias/filter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Categoria>> getCategorias(@RequestParam(value = "nome", required = false) String nome,@RequestParam(value = "descricao",required = false) String descricao) {

        List<Categoria> categorias = categoriaService.getCategoriasByFilter(nome,descricao);
        return ResponseEntity.ok(categorias);

    }

}
