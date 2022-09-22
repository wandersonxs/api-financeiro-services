package br.com.financeiro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoRequestDto {

    private String nome;

    private String descricao;

    private Integer tipo_Despesa_fk;

    private Double valor;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date data;

    private Integer situacao_fk;

    private Integer categoria_fk;

}
