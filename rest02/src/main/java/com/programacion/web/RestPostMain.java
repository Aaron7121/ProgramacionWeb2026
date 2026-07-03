package com.programacion.web;

import com.programacion.web.repositorios.UserRepository;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.SeBootstrap;

import java.net.URI;

public class RestPostMain {



    public static void main(String[] args) throws InterruptedException {
// PARA VER LA BASE DE DATOS
//        var emf = Persistence.createEntityManagerFactory("postgres");
//
//        var em =  emf.createEntityManager();
//
//        System.out.println(em);


//        var cdiConteniner = SeContainerInitializer.newInstance()
//                .initialize();
//
//        var repo = cdiConteniner.select(UserRepository.class).get();
//
//        repo.findAll()
//                .forEach(System.out::println);


        SeBootstrap.Configuration config = SeBootstrap.Configuration.builder()

                .port(8080)
                .protocol("http")
                .build();

        SeBootstrap.start(MyApplication.class, config).thenAccept(
                instance -> {
                    System.out.println(instance);
                    URI uri = instance.configuration().baseUri();

                    System.out.println("URL " + uri);

                    var emf = CDI.current().select(EntityManager.class).get();
                    System.out.println(emf);

                }
        ).exceptionally(ex -> {
            System.out.println(ex.getMessage());
            return null;
        });

        Thread.currentThread().join();


    }
}