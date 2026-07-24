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

import static jakarta.persistence.Persistence.createEntityManagerFactory;


@ApplicationScoped
public class JpaConfig {

    @PersistenceUnitName("dbposts")
    @Inject
    private EntityManagerFactory emf;

    @PostConstruct
    void init(){
        emf = createEntityManagerFactory("dbposts");
    }

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

    void closeEntityManager(@Disposes EntityManager em){
        if(em!=null && em.isOpen()){
            em.close();
        }

    }
/**
 * inyect, persistenceunit
 *  void init  crerate enty maagerfavct
 *
 *  aplicastion priduces,pulic entity manajer factory'
 * , produces pubklic ebtyty manajer
 *
 *void clouseenmf, (@disposes EntityManager em)
 * if(em !=null && em.isOpen()){
 *em.closed
 * }
 */




}