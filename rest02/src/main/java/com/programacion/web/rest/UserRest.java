package com.programacion.web.rest;

import com.programacion.web.data.dto.User;
import com.programacion.web.servicios.impl.UserServiceImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.beans.ConstructorProperties;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserRest {


   @Inject
     UserServiceImpl userServiceImpl;



    public UserRest() {
    }


    @GET
    public List<User> findAll() {
       return userServiceImpl.findAll();
    }

     @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Integer id){
        return userServiceImpl.findById(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();

    }

    @POST
    public Response create(User user) {
        User createdUser = userServiceImpl.save(user);
        return Response.status(Response.Status.CREATED)
                .entity(createdUser)
                .build();
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Integer id, User user) {
        userServiceImpl.findById(id)
                .ifPresent(existingUser -> {
                    user.setId(id); // 👈 Seteamos el ID de la URL al objeto antes de guardar
                    userServiceImpl.save(user);
                });
    }


    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        userServiceImpl.findById(id)
                .ifPresent(userServiceImpl::remove);
    }

}