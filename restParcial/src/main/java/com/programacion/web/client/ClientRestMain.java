package com.programacion.web.client;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

public class ClientRestMain {
        public static final String URL = "http://localhost:9090/api/productos";
    public static void main(String[] args) {

        try(var client = ClientBuilder.newClient();) {


            List<ProductoDto> productos= client.target(URL)

                    .request(MediaType.APPLICATION_JSON)
                    //aqui el metodo usado GET
                    .get(new GenericType<>() {});

                ProductoDto producto1= new ProductoDto();

                producto1.setNombre("ProductoXDDDDDDDDDD");
                producto1.setPrecio(55.5);

var response = client.target(URL).request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(producto1, MediaType.APPLICATION_JSON));
            if (response.getStatus() == 200 || response.getStatus() == 201) {
                System.out.println("Producto creado exitosamente.");
            } else {
                System.out.println("Error al crear el producto. Estado: " + response.getStatus());
                System.out.println("Respuesta: " + response.readEntity(String.class));
            }
            System.out.println(productos);
            System.out.println("estado " + response.getStatus());
        }catch (Exception e) {
            e.getMessage();
        }
    }



}
