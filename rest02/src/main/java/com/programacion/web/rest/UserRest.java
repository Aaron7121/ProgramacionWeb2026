package com.programacion.web.rest;

import com.programacion.web.data.dto.User;
import com.programacion.web.servicios.impl.UserServiceImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserRest {



    final UserServiceImpl userServiceImpl;

    @Inject
    public UserRest(UserServiceImpl userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

    @GET
    public Response findAll() {
        List<User> users = userServiceImpl.findAll();
        return Response.ok(users)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, Authorization")
                .build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Integer id){
        return userServiceImpl.findById(id)
                .map(user -> Response.ok(user)
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                        .header("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, Authorization")
                        .build())
                .orElse(Response.status(Response.Status.NOT_FOUND)
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                        .header("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, Authorization")
                        .build());

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