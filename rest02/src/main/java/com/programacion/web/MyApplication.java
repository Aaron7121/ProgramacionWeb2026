package com.programacion.web;


import com.programacion.web.config.CORSFilter;
import com.programacion.web.rest.*;
import jakarta.inject.Inject;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Application;
import org.jboss.resteasy.plugins.interceptors.CorsFilter;

import java.util.Set;

@ApplicationPath("/api")
public class MyApplication extends Application {



    @Override
    public Set<Class<?>> getClasses() {
        return Set.of(
                CORSFilter.class,
                UserRest.class,
                TodoRest.class,
                PostRest.class,
                PhotoRest.class,
                AlbumRest.class,
                CommentRest.class
        );
    }

}