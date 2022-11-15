package com.ecommerce.api.apiecommerce.Models;

import javax.persistence.*;
//
//@Entity
//@Table(name= "Address")
public class AddressModels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_address;
    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String rua;
    @Column()
    private String complemento;
    @Column(nullable = false, unique = true)
    private long numero;
    private long id_bairro;
    private boolean status_address;
    private long id_pessoa;
}
