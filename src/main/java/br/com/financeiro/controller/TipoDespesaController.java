package br.com.financeiro.controller;

import br.com.financeiro.dto.TipoDespesaRequestDto;
import br.com.financeiro.dto.TipoDespesaResponseDto;
import br.com.financeiro.model.Situacao;
import br.com.financeiro.model.TipoDespesa;
import br.com.financeiro.service.TipoDespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TipoDespesaController {

    @Autowired
    private TipoDespesaService tipoDespesaService;

    @RequestMapping(value = "/tiposDespesas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TipoDespesa>> getTiposDespesas() {

        List<TipoDespesa> tipoDespesa = tipoDespesaService.getTodosTiposDespesas();
        return ResponseEntity.ok(tipoDespesa);

    }

    @RequestMapping(value = "/tiposDespesas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipoDespesaResponseDto> addTipoDespesa(@RequestBody TipoDespesaRequestDto tipoDespesaRequestDto) {

        TipoDespesaResponseDto tipoDespesaResponseDto = tipoDespesaService.addTipoDespesa(tipoDespesaRequestDto);
        return new ResponseEntity(tipoDespesaResponseDto, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/tiposDespesas/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipoDespesaResponseDto> updateTipoDespesa(@PathVariable(value = "id") Long id, @RequestBody TipoDespesaRequestDto tipoDespesaRequestDto) {

        TipoDespesaResponseDto tipoDespesaResponseDto = tipoDespesaService.updateTipoDespesa(id, tipoDespesaRequestDto);
        return new ResponseEntity(tipoDespesaResponseDto, HttpStatus.OK);

    }

    @RequestMapping(value = "/tiposDespesas/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteTipoDespesa(@PathVariable(value = "id") Long id) {

        tipoDespesaService.deleteTipoDespesa(id);
        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping(value = "/tiposDespesas/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipoDespesaResponseDto> getByIdTipoDespesa(@PathVariable(value = "id") Long id) {

        TipoDespesaResponseDto tipoDespesa = tipoDespesaService.getByIdTipoDespesa(id);
        return ResponseEntity.ok(tipoDespesa);

    }

    @RequestMapping(value = "/tipoDespesa/filter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TipoDespesa>> getTipoDespesa(@RequestParam(value = "nome", required = false) String nome, @RequestParam(value = "descricao", required = false) String descricao) {

        List<TipoDespesa> tipoDespesa = tipoDespesaService.getTipoDespesaByFilter(nome, descricao);
        return ResponseEntity.ok(tipoDespesa);


    }
}