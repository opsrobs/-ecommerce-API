package com.ecommerce.api.apiecommerce.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "Pessoa")
public class PessoaModels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_pessoa;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cpf_cnpj;
    @Column(nullable = false)
    private Date data_nasc;
    @Column(nullable = false)
    private boolean admin;

    @OneToOne(mappedBy = "pessoa")
    private ClienteModels cliente;
}
