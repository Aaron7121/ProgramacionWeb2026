import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.time.LocalDateTime;
//usando get
// http:://8080/api/hola/...........

@Path("/chao")
public class ChaoRest {
    @GET
    public String chao() {
        return "chao" + LocalDateTime.now();


    }






}
