package br.com.financeiro.controller;

import br.com.financeiro.dto.LancamentoRequestDto;
import br.com.financeiro.dto.LancamentoResponseDto;
import br.com.financeiro.model.Lancamento;
import br.com.financeiro.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @RequestMapping(value = "/lancamentos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Lancamento>> getLancamentos() {

        List<Lancamento> lancamentos = lancamentoService.getTodosLancamentos();
        return ResponseEntity.ok(lancamentos);

    }

    @RequestMapping(value = "/lancamentos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LancamentoResponseDto> addLancamento(@RequestBody LancamentoRequestDto lancamentoRequestDto) {

        LancamentoResponseDto lancamentoResponseDto = lancamentoService.addLancamento(lancamentoRequestDto);
        return new ResponseEntity(lancamentoResponseDto, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/lancamentos/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LancamentoResponseDto> updateLancamento(@PathVariable(value = "id") Long id, @RequestBody LancamentoRequestDto lancamentoRequestDto) {

        LancamentoResponseDto lancamentoResponseDto = lancamentoService.updateLancamento(id, lancamentoRequestDto);
        return new ResponseEntity(lancamentoResponseDto, HttpStatus.OK);

    }

    @RequestMapping(value = "/lancamentos/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteLancamento(@PathVariable(value = "id") Long id) {

        lancamentoService.deleteLancamento(id);
        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping(value = "/lancamentos/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LancamentoResponseDto> getByIdLancamento(@PathVariable(value = "id") Long id) {

        LancamentoResponseDto lancamento = lancamentoService.getByIdLancamento(id);
        return ResponseEntity.ok(lancamento);

    }

    @RequestMapping(value = "/lancamentos/filter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Lancamento>> getLancamentos(@RequestParam(value = "nome", required = false) String nome,
                                                           @RequestParam(value = "descricao", required = false) String descricao,
                                                           @RequestParam(value = "valor", required = false) Double valor,
                                                           @RequestParam(value = "data", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date data) {

        List<Lancamento> lancamentos = lancamentoService.getLancamentosByFilter(nome, descricao, valor, data);
        return ResponseEntity.ok(lancamentos);

    }

}
