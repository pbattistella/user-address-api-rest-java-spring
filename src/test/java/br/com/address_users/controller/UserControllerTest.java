package br.com.address_users.controller;

import br.com.address_users.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;


@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserControllerTest {

    @LocalServerPort
    private int serverPort;

    @Test
    public void createUser() throws URISyntaxException {

        final String baseUrl = "http://localhost:" + serverPort + "/user";
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI(baseUrl);

        User user = new User();
        user.setName("Joana Samira Oliveira");
        user.setBirthDate(new Date());

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<User> request = new HttpEntity<>(user, headers);

        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);

        Assertions.assertEquals(result.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    public void readAll() throws URISyntaxException{
        final String baseUrl = "http://localhost:" + serverPort + "/user";
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

        Assertions.assertEquals(result.getStatusCode(), HttpStatus.OK);

    }


}
