package com.programacion.web.rest;


import com.programacion.web.data.dto.Cliente;
import com.programacion.web.servicios.impl.ClienteServiceImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteRest {

    private static final Logger LOGGER = Logger.getLogger(ClienteRest.class.getName());
    final ClienteServiceImpl clienteService;

    @Inject
    public ClienteRest(ClienteServiceImpl clienteService) {
        this.clienteService = clienteService;
    }

    @GET
    public Response findAll() {

        return Response.ok(clienteService.findAll()).build();

    }
    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Integer id) {
        return clienteService.findById(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @POST
    public Response create(Cliente cliente) {
        Cliente createdCliente = clienteService.save(cliente);
        return Response.status(Response.Status.CREATED)
                .entity(createdCliente)
                .build();
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Integer id, Cliente cliente) {
        clienteService.findById(id)
                .ifPresent(existingCliente -> {
                    cliente.setId(id); // Seteamos el ID de la URL al objeto antes de guardar
                    clienteService.save(cliente);
                });
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        clienteService.findById(id)
                .ifPresent(clienteService::remove);
    }

}
