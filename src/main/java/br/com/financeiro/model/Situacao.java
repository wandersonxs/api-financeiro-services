package br.com.financeiro.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "situacoes")

public class Situacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;
}
