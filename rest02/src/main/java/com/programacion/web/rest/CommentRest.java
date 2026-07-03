package com.programacion.web.rest;

import com.programacion.web.data.dto.Comment;
import com.programacion.web.servicios.impl.CommentServiceImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("comments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentRest {

    final CommentServiceImpl commentServiceImpl;

    @Inject
    public CommentRest(CommentServiceImpl commentServiceImpl){
        this.commentServiceImpl = commentServiceImpl;
    }

    @GET
    public List<Comment> findAll() {
        return commentServiceImpl.findAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Integer id){
        return commentServiceImpl.findById(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Integer id, Comment comment) {
        commentServiceImpl.findById(id)
                .ifPresent(existingComment ->
                        commentServiceImpl.save(comment));
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        commentServiceImpl.findById(id)
                .ifPresent(commentServiceImpl::delete);
    }
}