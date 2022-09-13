package br.com.financeiro.controller;

import br.com.financeiro.model.Lancamento;
import br.com.financeiro.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


}
