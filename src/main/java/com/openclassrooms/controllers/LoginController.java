package com.openclassrooms.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController()
@RequestMapping()
public class LoginController {

    @GetMapping(path = "/user")
    public String getUser(){
        return "Welcome, user";
    }

    @GetMapping(path = "/admin")
    public String getAdmin(){
        return "Welcome, admin";
    }

    @GetMapping("/")
    public String getGithub(Principal user){
        StringBuffer userInfo = new StringBuffer(); //Un "StringBuffer" est un objet en java qui permet de manupiler des chaines de caractère en Java
        return user.toString();
    }

}
