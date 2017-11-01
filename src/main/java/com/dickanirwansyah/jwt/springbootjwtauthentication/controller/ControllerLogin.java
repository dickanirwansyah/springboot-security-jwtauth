package com.dickanirwansyah.jwt.springbootjwtauthentication.controller;

import com.dickanirwansyah.jwt.springbootjwtauthentication.dao.UserDAO;
import com.dickanirwansyah.jwt.springbootjwtauthentication.entities.Users;
import com.dickanirwansyah.jwt.springbootjwtauthentication.secure.jwt.JwtAccountCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerLogin {

    @Autowired
    UserDAO userDAO;

    @PostMapping(value = "/login")
    public ResponseEntity<String> loginJwt(@RequestBody JwtAccountCredentials credentials){

        return ResponseEntity.ok().body(credentials.getUsername() + "\n" +
        credentials.getPassword() + "\n" + "Kamu dapat mengakses page ini");
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<Users> singupUsers(@RequestBody Users users){

        Users result_console = userDAO.save(users);

        return ResponseEntity.ok().body(result_console);
    }
}
