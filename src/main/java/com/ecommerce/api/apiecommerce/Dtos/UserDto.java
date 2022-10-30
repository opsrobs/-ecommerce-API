package com.ecommerce.api.apiecommerce.Dtos;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class UserDto {

    @NotBlank
    private String username;
    @NotBlank
    private String first_name;
    @NotBlank
    private String last_name;

    @NotBlank
    private String password;


    public UserDto(String username, String first_name, String last_name, String password) {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
    }

    public UserDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
