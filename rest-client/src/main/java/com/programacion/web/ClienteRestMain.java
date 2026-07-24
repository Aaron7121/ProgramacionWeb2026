package com.programacion.web;

import com.programacion.web.dto.UserDto;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

public class ClienteRestMain {

    public static final String USERS_URL = "https://jsonplaceholder.typicode.com/users";

    static void main(String[] args) {

        try (var client = ClientBuilder.newClient()) {


            UserDto user1 = client.target(USERS_URL)
                    .path("/{id}")
                    .resolveTemplate("id", 1)
                    .request(MediaType.APPLICATION_JSON)
                    .get(UserDto.class);

            System.out.println("GET (ID 1): " + user1);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}