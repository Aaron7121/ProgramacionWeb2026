package com.programacion.web;

import com.programacion.web.db.JpaConfig;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.Set;
@ApplicationPath("/api")
public class MyApplication extends Application {


    @Override
    public Set<Class<?>> getClasses() {

        return Set.of();

    }

}
