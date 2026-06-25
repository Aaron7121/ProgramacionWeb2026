package com.programacion.web.db;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.Produces;

import javax.swing.text.html.parser.Entity;

@ApplicationScoped
public class JpaConfig {

    private EntityManagerFactory emf;

    @PostConstruct
    void init(){

        emf = Persistence.createEntityManagerFactory("dbposts");

    }
    @Produces
    @ApplicationScoped
    public EntityManager getEntityManager(){
        return  emf.createEntityManager();

    }


    void closeEntityManager(@Disposes EntityManager em){
        if (em !=  null && em.isOpen()){
            em.close();
        }
    }
}
