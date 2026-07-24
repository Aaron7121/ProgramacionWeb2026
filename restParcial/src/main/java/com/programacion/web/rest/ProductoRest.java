package com.programacion.web.rest;

import com.programacion.web.data.dto.Cliente;
import com.programacion.web.data.dto.Producto;
import com.programacion.web.servicios.impl.ClienteServiceImpl;
import com.programacion.web.servicios.impl.ProductoServiceImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.logging.Logger;

@Path("/productos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductoRest {

    final ProductoServiceImpl productoService;

    @Inject
    public ProductoRest(ProductoServiceImpl productoService) {
        this.productoService = productoService;
    }

    @GET
    public Response listarProducto( @QueryParam("precio") Double precio

            , @QueryParam("nombre") String nombre) {


       if(precio==null && nombre==null){

           return Response.ok(productoService.findAll()).build();
       }
        List<Producto> list= productoService.filtroDinamico(precio, nombre);



        return Response.ok(list).build();

    }
/*
    @GET
    public Response filtroPrecio ( @QueryParam("precio") double precio) {
    List<Producto> productos = productoService.filtrarmayorQuePrecio(precio);
return Response.ok(productos).build();
    }
*/
    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Integer id) {
        return productoService.findById(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @POST
    public Response create(Producto producto) {
        Producto createdProducto = productoService.save(producto);
        return Response.status(Response.Status.CREATED)
                .entity(createdProducto)
                .build();
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Integer id, Producto producto) {
        productoService.findById(id)
                .ifPresent(existingProducto -> {
                    producto.setId(id); // Seteamos el ID de la URL al objeto antes de guardar
                    productoService.save(producto);
                });
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        productoService.findById(id)
                .ifPresent(productoService::remove);
    }

}
