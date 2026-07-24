package com.programacion.web.rest;


import com.programacion.web.data.dto.Todo;
import com.programacion.web.servicios.impl.TodoServiceImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;


@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoRest {

    final TodoServiceImpl todoServiceImpl;

    @Inject
    public TodoRest(TodoServiceImpl todoServiceImpl) {
        this.todoServiceImpl = todoServiceImpl;
    }
    public TodoRest( ) {
        todoServiceImpl = null;
    }


    @GET
    public List<Todo> findAll(){ return todoServiceImpl.findAll();}


}