package com.ecommerce.api.apiecommerce.Dtos;

import com.ecommerce.api.apiecommerce.Models.RolesModels;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class PessoaDto {

    @NotBlank
    private String userName;
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf_cnpj;
    @NotBlank
    private String password;
    @NotNull
    private Date data_nasc;

    @NotEmpty
    private List<RolesModels> roles;

    public PessoaDto(String userName, String nome, String cpf_cnpj, String password, Date data_nasc, List<RolesModels> roles) {
        this.userName = userName;
        this.nome = nome;
        this.cpf_cnpj = cpf_cnpj;
        this.password = password;
        this.data_nasc = data_nasc;
        this.roles = roles;
    }

    public PessoaDto() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public List<RolesModels> getRoles() {
        return roles;
    }

    public void setRoles(List<RolesModels> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "PessoaDto{" +
                "userName='" + userName + '\'' +
                ", nome='" + nome + '\'' +
                ", cpf_cnpj='" + cpf_cnpj + '\'' +
                ", password='" + password + '\'' +
                ", data_nasc=" + data_nasc +
                ", roles=" + roles +
                '}';
    }
}
