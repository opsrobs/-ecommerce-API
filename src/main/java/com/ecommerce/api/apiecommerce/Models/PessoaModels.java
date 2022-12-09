package com.ecommerce.api.apiecommerce.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "Users")
public class PessoaModels implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userID;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cpf_cnpj;
    @Column(nullable = false)
    private Date data_nasc;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String password;
    @ManyToMany
    @JoinTable(name = "TB_USERS_ROLES",
    joinColumns = @JoinColumn(name= "user_id"),
    inverseJoinColumns = @JoinColumn(name= "role_id"))
    private List<RolesModels> roles;
    @OneToOne(mappedBy = "pessoa")
//    @JsonIgnore
    private ClienteModels cliente;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER) // OneToMany associate aos contacts
    @Fetch(FetchMode.SUBSELECT)
    private List<UserContatoModels> contatos;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER) // OneToMany associate aos Emails
    @Fetch(FetchMode.SUBSELECT)
    private List<UserEmailModels> emails;


    public PessoaModels(long userID, String nome, String cpf_cnpj, Date data_nasc, String userName,
                      String password, List<RolesModels> roles, ClienteModels cliente, List<UserContatoModels>
                              contatos, List<UserEmailModels> emails) {
        this.userID = userID;
        this.nome = nome;
        this.cpf_cnpj = cpf_cnpj;
        this.data_nasc = data_nasc;
        this.userName = userName;
        this.password = password;
        this.roles = roles;
//        this.cliente = cliente;
        this.contatos = contatos;
        this.emails = emails;
    }

    public PessoaModels(long userID, String nome, String cpf_cnpj, Date data_nasc, boolean admin, String userName, String password) {
        this.userID = userID;
        this.nome = nome;
        this.cpf_cnpj = cpf_cnpj;
        this.data_nasc = data_nasc;
        this.userName = userName;
        this.password = password;
    }



    public PessoaModels() {
    }

    public PessoaModels(String username) {

    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @JsonIgnore
    public String getUsername() {
        return this.userName;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public List<RolesModels> getRoles() {
        return roles;
    }

    public void setRoles(List<RolesModels> roles) {
        this.roles = roles;
    }

    public List<UserContatoModels> getContatos() {
        return contatos;
    }

    public void setContatos(List<UserContatoModels> contatos) {
        this.contatos = contatos;
    }

    public List<UserEmailModels> getEmails() {
        return emails;
    }

    public void setEmails(List<UserEmailModels> emails) {
        this.emails = emails;
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

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

//    public ClienteModels getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(ClienteModels cliente) {
//        this.cliente = cliente;
//    }

//    @Override
//    public String toString() {
//        return "PessoaModels{" +
//                "userID=" + userID +
//                ", nome='" + nome + '\'' +
//                ", cpf_cnpj='" + cpf_cnpj + '\'' +
//                ", data_nasc=" + data_nasc +
//                ", userName='" + userName + '\'' +
//                ", password='" + password + '\'' +
//                ", roles=" + roles +
//                ", cliente=" + cliente +
//                ", contatos=" + contatos +
//                ", emails=" + emails +
//                '}';
//    }
}