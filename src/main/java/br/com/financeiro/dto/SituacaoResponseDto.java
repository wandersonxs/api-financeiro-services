package br.com.financeiro.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SituacaoResponseDto {

    private Long Id;

    private String Nome;

    private String Descricao;
}
