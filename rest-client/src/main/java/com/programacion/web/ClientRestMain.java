package com.programacion.web;

import com.programacion.web.dto.User;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

public class ClientRestMain {
        public static final String USERS_URL= "http://localhost:8080/api/users/";

    public static void main(String[] args) {


        try(   var client=     ClientBuilder.newClient();) {
//GET

    var user1 = client.target(USERS_URL+ "{id}")
            .resolveTemplate("id", 1)
            .request(MediaType.APPLICATION_JSON).get(User.class);


            User users = client.target(USERS_URL)

                    .request(MediaType.APPLICATION_JSON).get(User.class);


            List<User> usersList = client.target(USERS_URL)

                    .request(MediaType.APPLICATION_JSON).get(new GenericType<>() {});


            System.out.println(user1);
            System.out.println(users);

            System.out.println(usersList);
//POST


            var newuser= new User();


            newuser.setName("mibicho");
            newuser.setEmail("asdasd");
            newuser.setUsername("asasdasdasddasd");


            var response= client.target(USERS_URL)
                    .request(MediaType.APPLICATION_JSON).
                    post(Entity.entity(newuser,MediaType.APPLICATION_JSON));


            System.out.println("ESTADO : " + response.getStatus());



            //PUT

            var responsePut= client.target(USERS_URL)
                    .request(MediaType.APPLICATION_JSON).
                    put(Entity.entity(newuser,MediaType.APPLICATION_JSON));


            //delete
//            var responseDelete=client.target(USERS_URL+ "{id}")
//                    .resolveTemplate("id", 1)
//                    .request(MediaType.APPLICATION_JSON).
//                    delete();
//
//
//            responseDelete.getStatus();
//            System.out.println( responseDelete.getStatus());



        }
    }
}
