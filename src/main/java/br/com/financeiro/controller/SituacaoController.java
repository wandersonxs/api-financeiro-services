package br.com.financeiro.controller;




import br.com.financeiro.dto.SituacaoRequestDto;
import br.com.financeiro.dto.SituacaoResponseDto;
import br.com.financeiro.model.Categoria;
import br.com.financeiro.model.Situacao;
import br.com.financeiro.service.SituacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @CrossOrigin(origins = "http://localhost:4200")

    public class SituacaoController {

        @Autowired
        private SituacaoService situacaoService;

        @RequestMapping(value = "/situacao", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Situacao>> getSituacao() {

            List<Situacao> situacoes = situacaoService.getTodasSituacoes();
            return ResponseEntity.ok(situacoes);

        }

        @RequestMapping(value = "/situacao", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<SituacaoResponseDto> addSituacao(@RequestBody SituacaoRequestDto situacaoRequestDto) {

            SituacaoResponseDto situacaoResponseDto = situacaoService.addSituacao(situacaoRequestDto);
            return new ResponseEntity(situacaoResponseDto, HttpStatus.CREATED);

        }

        @RequestMapping(value = "/situacao/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<SituacaoResponseDto> updateSituacao(@PathVariable(value = "id") Long id, @RequestBody SituacaoRequestDto situacaoRequestDto) {

            SituacaoResponseDto situacaoResponseDto = situacaoService.updateSituacao(id, situacaoRequestDto);
            return new ResponseEntity(situacaoResponseDto, HttpStatus.OK);

        }

        @RequestMapping(value = "/situacao/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Void> deleteSituacao(@PathVariable(value = "id") Long id) {

            situacaoService.deleteSituacao(id);
            return new ResponseEntity(HttpStatus.OK);

        }

        @RequestMapping(value = "/situacao/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<SituacaoResponseDto> getByIdSituacao(@PathVariable(value = "id") Long id) {

            SituacaoResponseDto situacao = situacaoService.getByIdSituacao(id);
            return ResponseEntity.ok(situacao);

        }

        @RequestMapping(value = "/categorias/filter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Situacao>> getSituacao(@RequestParam(value = "nome", required = false) String nome, @RequestParam(value = "descricao", required = false) String descricao) {

            List<Situacao> situacao = situacaoService.getSituacaoByFilter(nome, descricao);
            return ResponseEntity.ok(situacao);

        }
    }
