package com.ecommerce.api.apiecommerce.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Contato_Email")
public class UserEmailModels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_email;
    @JsonIgnore
    @ManyToOne @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private UserModels user;
    @Column(nullable = false)
    private Date date_created;
    @Column(nullable = false)
    private boolean status_email;
    @Column(nullable = false)
    private String email;

    public UserEmailModels(long id_email, UserModels user, Date date_created, boolean status_email, String email) {
        this.id_email = id_email;
        this.user = user;
        this.date_created = date_created;
        this.status_email = status_email;
        this.email = email;
    }

    public UserEmailModels() {
    }

    public long getId_email() {
        return id_email;
    }

    public void setId_email(long id_email) {
        this.id_email = id_email;
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

    public boolean isStatus_email() {
        return status_email;
    }

    public void setStatus_email(boolean status_email) {
        this.status_email = status_email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserEmailModels{" +
                "id_email=" + id_email +
                ", user=" + user +
                ", date_created=" + date_created +
                ", status_email=" + status_email +
                ", email='" + email + '\'' +
                '}';
    }
}
