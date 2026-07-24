package com.programacion.web.config;


import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceUnit;
import org.apache.deltaspike.jpa.api.entitymanager.PersistenceUnitName;


@ApplicationScoped
public class JpaConfig {

    @PersistenceUnitName("dbposts")
    @Inject
    private EntityManagerFactory emf;



    @Produces
    @ApplicationScoped
    public EntityManagerFactory emf(){
        return emf;
    }

    @Produces
    @ApplicationScoped
    public EntityManager entityManager(){
        return emf.createEntityManager();
    }

    @PostConstruct
    void init(){
        emf = Persistence.createEntityManagerFactory("dbposts");
    }

    void closeEntityManager(@Disposes EntityManager em){
        if(em!=null && em.isOpen()){
            em.close();
        }

    }




}