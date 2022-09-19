package br.com.financeiro.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "lancamentos")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "tipo_despesa", nullable = false)
    private Integer tipoDespesa;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Date data;

}
