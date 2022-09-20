package br.com.financeiro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoRequestDto {

    private String nome;

    private String descricao;

    private Integer tipoDespesa;

    private Double valor;

    private Integer situacao;

    private Integer categoria;

}
