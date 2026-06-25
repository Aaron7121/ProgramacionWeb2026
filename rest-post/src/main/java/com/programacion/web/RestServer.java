package com.programacion.web;

import jakarta.enterprise.inject.spi.CDI;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.SeBootstrap;

import java.net.URI;

public class RestServer {

    static void main() throws Exception {

    /*    var emf = Persistence.createEntityManagerFactory("dbposts");
    var em= emf.createEntityManager();
        System.out.println(em);
*/
        //este es el contenedor Bootstrap SE , ahora necesitamos El SERVIDOR HTTP
        SeBootstrap.Configuration config = SeBootstrap.Configuration.builder()
                .port(8080)
                .protocol("http").build()
                ;
        SeBootstrap.start(MyApplication.class,config).thenAccept(
                instance->{
                    System.out.println(instance);
                    URI uri = instance.configuration().baseUri();

                    System.out.println(uri);

                    var emf = CDI.current().select(MyApplication.class).get();
                    System.out.println(emf);
                }



        ).exceptionally(ex->{
            System.out.println(ex.getMessage());
            return null;

        });
        Thread.currentThread().join();
    }
}
