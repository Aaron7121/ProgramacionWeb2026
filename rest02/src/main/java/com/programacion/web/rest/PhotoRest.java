package com.programacion.web.rest;

import com.programacion.web.data.dto.Photo;
import com.programacion.web.servicios.impl.PhotoServiceImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("photos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PhotoRest {

    final PhotoServiceImpl photoServiceImpl;

    @Inject
    public PhotoRest(PhotoServiceImpl photoServiceImpl){
        this.photoServiceImpl = photoServiceImpl;
    }

    @GET
    public List<Photo> findAll() {
        return photoServiceImpl.findAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Integer id){
        return photoServiceImpl.findById(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Integer id, Photo photo) {
        photoServiceImpl.findById(id)
                .ifPresent(existingPhoto ->
                        photoServiceImpl.save(photo));
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        photoServiceImpl.findById(id)
                .ifPresent(photoServiceImpl::delete);
    }
}