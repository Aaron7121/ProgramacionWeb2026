package com.programacion.web.rest;


import com.programacion.web.data.dto.Post;
import com.programacion.web.data.dto.User;
import com.programacion.web.servicios.impl.PostServiceImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.NoArgsConstructor;
import org.jboss.logging.annotations.Pos;

import java.util.List;
import java.util.Optional;
@Path("/posts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostRest {



    final PostServiceImpl postService;

    @Inject
    public PostRest(PostServiceImpl postService) {
        this.postService = postService;
    }

    public PostRest() {
        this.postService = null; // Inicialización por defecto
    }

    @GET
    public List<Post> findAll(){return postService.findAll();}

    @GET
    @Path("/{id}")
    public Optional<Post> findById(@PathParam("id") Integer id){


        return postService.findById(id);
    }

    @POST
    public Response create(Post post) {
        // Para crear un nuevo post, el ID debe ser 0 o null

        Post createdPost = postService.create(post);
        return Response.status(Response.Status.CREATED)
                .entity(createdPost)
                .build();
    }




}