package com.ecommerce.api.apiecommerce.Models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name= "Users")
public class UserModels implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userID;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String last_name;
    @Column(nullable = false)
    private String password;
    @ManyToMany
    @JoinTable(name = "TB_USERS_ROLES",
    joinColumns = @JoinColumn(name= "user_id"),
    inverseJoinColumns = @JoinColumn(name= "role_id"))
    private List<RolesModels> roles;

    //============//
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER) // OneToMany associate aos contacts
    @Fetch(FetchMode.SUBSELECT)
    private List<UserContatoModels> contatos;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER) // OneToMany associate aos Emails
    @Fetch(FetchMode.SUBSELECT)
    private List<UserEmailModels> emails;



    public UserModels(long userID, String userName, String first_name, String last_name, String password,
                      List<RolesModels> roles, List<UserContatoModels> contatos, List<UserEmailModels> emails) {
        this.userID = userID;
        this.userName = userName;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.roles = roles;
        this.contatos = contatos;
        this.emails = emails;
    }

    public UserModels(long userID, String userName, String first_name, String last_name, String password) {
        this.userID = userID;
        this.userName = userName;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password =password;
    }

    public UserModels() {
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.userName = userName;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "UserModels{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", contatos=" + contatos +
                ", emails=" + emails +
                '}';
    }
}