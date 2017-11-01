package com.dickanirwansyah.jwt.springbootjwtauthentication.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "users",
        catalog = "belajarjwt")
public class Users implements Serializable{

    @Id @Column(name = "idusers")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusers;

    @Column(name = "username", nullable = false, unique = true)
    @NotNull(message = "username masih kosong !")
    private String username;

    @Column(name = "password", nullable = false)
    @NotNull(message = "password masih kosong !")
    private String password;

    @Column(name = "firstname", nullable = false)
    @NotNull(message = "firstname masih kosong !")
    private String firstname;

    public Long getIdusers(){
        return idusers;
    }

    public void setIdusers(Long idusers){
        this.idusers = idusers;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
}
