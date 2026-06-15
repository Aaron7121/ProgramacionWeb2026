import dto.Customer;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.awt.*;
import java.util.Map;
@Path("/customers")
public class CustomerRest {

    private static Map<Integer, Customer> customers = Map.of(
            1, Customer.builder().id(1).name("cliente1").direccion("asd").build(),
            2, Customer.builder().id(2).name("cliente2").direccion("asddda").build(),
            3, Customer.builder().id(3).name("cliente3").direccion("astyjhjd").build(),
            4, Customer.builder().id(4).name("cliente4").direccion("a,mm,msd").build(),
            5, Customer.builder().id(5).name("cliente5").direccion("am,msd").build()

            );
//Proveeedor para convertir obj a Json
@GET
@Path("/{id}")
@Produces({MediaType.APPLICATION_JSON})
            public Customer findById (@PathParam("id") Integer id){
         var customer = CustomerRest.customers.get(id);

         return  customer;
         //aqui es si retornabamos un String que es poco practico
    //para esto necestamos una extencion
//         if (customer == null){
//
//             return "Cuestomer not found" ;
//         }
//         String json  = """
//                 {
//                 "id" : %d,
//                 "name": "%s",
//                 "direccion": "%s"
//
//                 }
//                 """.formatted(customer.getId(),customer.getName(),customer.getDireccion());
//
//         return  json;

            }

}
