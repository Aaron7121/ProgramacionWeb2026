package com.programacion.web.rest;

import com.programacion.web.data.dto.Cliente;
import com.programacion.web.data.dto.OrdenCompra;
import com.programacion.web.servicios.impl.ClienteServiceImpl;
import com.programacion.web.servicios.impl.OrdenCompraServiceImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.logging.Logger;

@Path("/ordenes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrdenCompraRest {

    private static final Logger LOGGER = Logger.getLogger(ClienteRest.class.getName());
    final OrdenCompraServiceImpl ordenCompraService;

    @Inject
    public OrdenCompraRest(OrdenCompraServiceImpl ordenCompraService) {
        this.ordenCompraService = ordenCompraService;
    }

    @GET
    public List<OrdenCompra> findAll() {

        return ordenCompraService.findAll();

    }
    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Integer id) {
        return ordenCompraService.findById(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @POST
    public Response create(OrdenCompra ordenCompra) {
        try {
            LOGGER.info("Received OrdenCompra: " + ordenCompra);

            OrdenCompra createdOrdenCompra = ordenCompraService.save(ordenCompra);
            return Response.status(Response.Status.CREATED)
                    .entity(createdOrdenCompra)
                    .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An unexpected error occurred")
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Integer id, OrdenCompra ordenCompra) {
        ordenCompraService.findById(id)
                .ifPresent(existingOrdenCompra -> {
                    ordenCompra.setId(id); // Seteamos el ID de la URL al objeto antes de guardar
                    ordenCompraService.save(ordenCompra);
                });
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        ordenCompraService.findById(id)
                .ifPresent(ordenCompraService::remove);
    }
}
