package br.com.address_users.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
//@CrossOrigin(origins = "http://address.users.com.br")
public class IndexController {

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> index(){
        return Collections.singletonMap("message", "API Address Users running!");
    }
}
