package br.com.financeiro.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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

    @Column(name = "tipo_despesa_fk", nullable = false)
    private Integer tipoDespesa;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Date data;

//    @Column(name = "categoria_fk", nullable = false)
    @OneToOne
    @JoinColumn(name = "categoria_fk", referencedColumnName = "id")
    private Categoria categoria;

    @Column(name = "situacao_fk", nullable = false)
    private Integer situacao;

}
