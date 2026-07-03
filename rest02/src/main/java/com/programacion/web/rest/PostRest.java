package com.programacion.web.rest;


import com.programacion.web.data.dto.Post;
import com.programacion.web.servicios.impl.PostServiceImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("posts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostRest {

    final PostServiceImpl postService;

    @Inject
    public PostRest(PostServiceImpl postService) {
        this.postService = postService;
    }

    @GET
    public List<Post> findAll(){return postService.findAll();}



}