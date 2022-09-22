package br.com.financeiro.dto;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SituacaoRequestDto {

    private String Nome;

    private String Descricao;

}
