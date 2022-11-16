package com.ecommerce.api.apiecommerce.Dtos;

import com.ecommerce.api.apiecommerce.Models.UserModels;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class UserEmailDto {

    @NotNull
    private UserModels user;
    @NotNull
    private Date date_created;
    @NotNull
    private boolean status_email;
    @NotNull
    private String email;

    public UserEmailDto(UserModels user, Date date_created, boolean status_email, String email) {
        this.user = user;
        this.date_created = date_created;
        this.status_email = status_email;
        this.email = email;
    }

    public UserEmailDto() {
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
}
