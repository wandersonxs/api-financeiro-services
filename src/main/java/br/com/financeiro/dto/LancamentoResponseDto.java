package br.com.financeiro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoResponseDto {

    private Long id;

    private String nome;

    private String descricao;

    private Integer tipoDespesa;

    private Double valor;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date data;

    private Integer categoriaId;

    private Integer situacao;

    private CategoriaResponseDto categoria;

}
