package com.ecommerce.api.apiecommerce.Dtos;

import com.ecommerce.api.apiecommerce.Models.UserModels;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class UserContatoDto {
    private UserModels user;
    @NotNull
    private Date date_created;
    @NotNull
    private boolean status_telefone;
    @NotBlank
    private String telefone;

    public UserContatoDto(UserModels user, Date date_created, boolean status_telefone, String telefone) {
        this.user = user;
        this.date_created = date_created;
        this.status_telefone = status_telefone;
        this.telefone = telefone;
    }

    public UserContatoDto() {
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
        return "UserContatoDto{" +
                "user=" + user +
                ", date_created=" + date_created +
                ", status_telefone=" + status_telefone +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
