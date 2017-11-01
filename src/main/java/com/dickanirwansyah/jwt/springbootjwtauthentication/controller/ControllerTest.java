package com.dickanirwansyah.jwt.springbootjwtauthentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {

    @GetMapping(value = "/home")
    public String getTest(){
        return "TEST HALLO";
    }
}
