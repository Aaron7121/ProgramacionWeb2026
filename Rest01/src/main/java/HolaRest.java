import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import org.apache.http.HttpServerConnection;
import org.apache.http.impl.bootstrap.HttpServer;

import java.time.LocalDateTime;
// http:://8080/api/hola/...........
@Path("/hola")
public class HolaRest {

    // http:://8080/api/hola/mundo...........

    @GET
    @Path("/mundo1")
    public String hola() {
        return "hola" + LocalDateTime.now();
    }

//USO PATHParam

    // http:://8080/api/hola/mundo2/{nombre}...........

    @GET
    @Path("/mundo2/{nombre}/{apellido}")
    public String hola2(@PathParam("nombre")  String nombre , @PathParam("apellido")  String apellido) {
        return "hola mundo2 " + nombre + " " + apellido;
    }



    //USO QueryParams
    //se usa para ordenamiento o filtrps y para identificar los recursos
    //orenamiento de una coleccion completa,NO PUEDO HACER /PERSONAS/SORT=ASD NO SE PUEDE POR QUE ESO ES UN DATO INDIVIDUAL
    // http:://8080/api/hola/mundo3?nombre=aa$apellido=aa...........

    @GET
    @Path("/mundo3")
    public String hola3(@QueryParam("nombre")  String nombre , @QueryParam("apellido") @DefaultValue("bichoSIUUUUU") String apellido) {
        return "hola mundo3 " + nombre + " " + apellido;
    }

    // http:://8080/api/hola/mundo4/nombre=aa..........

    @GET
    @Path("/mundo4")
    public String hola3(@Context HttpServletRequest request) {

        var Host = request.getHeader("Host");

            var nombre = request.getParameter("nombre");

            return "hola mundo4 " + Host + " " + nombre;

    }


}
