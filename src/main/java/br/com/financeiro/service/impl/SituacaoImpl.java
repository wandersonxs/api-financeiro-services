package br.com.financeiro.service.impl;



import br.com.financeiro.dto.SituacaoRequestDto;
import br.com.financeiro.dto.SituacaoResponseDto;
import br.com.financeiro.model.Situacao;
import br.com.financeiro.repository.SituacaoRepository;
import br.com.financeiro.service.SituacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

    @Service
    public class SituacaoImpl implements SituacaoService{

        @Autowired
        private SituacaoRepository situacaoRepository;

        @Override
        public List<Situacao> getTodasSituacoes() {
            return situacaoRepository.findAll();
        }
        @Override
        public SituacaoResponseDto addSituacao(SituacaoRequestDto situacaoRequestDto) {

            Situacao situacao = new Situacao();

            situacao.setNome(situacaoRequestDto.getNome());
            situacao.setDescricao(situacaoRequestDto.getDescricao());

            Situacao situacaoSaved = situacaoRepository.save(situacao);

            SituacaoResponseDto situacaoResponseDto = new SituacaoResponseDto();
            situacaoResponseDto.setId(situacaoSaved.getId());
            situacaoResponseDto.setNome(situacaoSaved.getNome());
            situacaoResponseDto.setDescricao(situacaoSaved.getDescricao());

            return situacaoResponseDto;
        }

        @Override
        public SituacaoResponseDto updateSituacao(Long id, SituacaoRequestDto situacaoRequestDto) {
            Situacao situacao = situacaoRepository.findById(id).get();

            situacao.setNome(situacaoRequestDto.getNome());
            situacao.setDescricao(situacaoRequestDto.getDescricao());

           Situacao situacaoSaved = situacaoRepository.save(situacao);

            SituacaoResponseDto situacaoResponseDto = new SituacaoResponseDto();
            situacaoResponseDto.setId(situacaoSaved.getId());
            situacaoResponseDto.setNome(situacaoSaved.getNome());
            situacaoResponseDto.setDescricao(situacaoSaved.getDescricao());
            return situacaoResponseDto;
        }

        @Override
        public SituacaoResponseDto getByIdSituacao(Long id) {

            SituacaoResponseDto situacaoResponseDto = new SituacaoResponseDto();
            Optional<Situacao> situacao = situacaoRepository.findById(id);

            if (situacao.isPresent()) {

                situacaoResponseDto.setId(situacao.get().getId());
                situacaoResponseDto.setNome(situacao.get().getNome());
                situacaoResponseDto.setDescricao(situacao.get().getDescricao());
            }
            return situacaoResponseDto;
        }
        @Override
        public void deleteSituacao(Long id) {

            situacaoRepository.deleteById(id);

        }
    }

