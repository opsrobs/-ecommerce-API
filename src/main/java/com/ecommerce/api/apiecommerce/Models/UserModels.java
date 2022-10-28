package com.ecommerce.api.apiecommerce.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name= "Users")
public class UserModels implements Serializable {
    public static final long serialVersionUUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userID;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String last_name;

    public UserModels(UUID userID, String userName, String first_name, String last_name) {
        this.userID = userID;
        this.userName = userName;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public UserModels() {
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
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
}
