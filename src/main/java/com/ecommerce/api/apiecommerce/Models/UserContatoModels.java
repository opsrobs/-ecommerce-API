package com.ecommerce.api.apiecommerce.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Contato_Telefone")
public class UserContatoModels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_contato;
    @JsonIgnore
    @ManyToOne @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private UserModels user;
    @Column(nullable = false)
    private Date date_created;
    @Column(nullable = false)
    private boolean status_telefone;
    @Column(nullable = false)
    private String telefone;

    public UserContatoModels(long id_contato, UserModels user, Date date_created, boolean status_telefone, String telefone) {
        this.id_contato = id_contato;
        this.user = user;
        this.date_created = date_created;
        this.status_telefone = status_telefone;
        this.telefone = telefone;
    }

    public UserContatoModels() {
    }

    public long getId_contato() {
        return id_contato;
    }

    public void setId_contato(long id_contato) {
        this.id_contato = id_contato;
    }

    public UserModels getUser() {
        return user;
    }

    public void setUser(UserModels user) {
        this.user = user;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public boolean isStatus_telefone() {
        return status_telefone;
    }

    public void setStatus_telefone(boolean status_telefone) {
        this.status_telefone = status_telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "UserContatoModels{" +
                "id_contato=" + id_contato +
                ", user=" + user.getUserID() +
                ", date_created=" + date_created +
                ", status_telefone=" + status_telefone +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
