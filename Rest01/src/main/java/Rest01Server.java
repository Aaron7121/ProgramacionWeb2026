import jakarta.ws.rs.SeBootstrap;
import jakarta.ws.rs.core.Application;

import java.net.URI;

public class Rest01Server {
    public static void main(String[] args) throws Exception {




        //este es el contenedor Bootstrap SE , ahora necesitamos El SERVIDOR HTTP
        SeBootstrap.Configuration config = SeBootstrap.Configuration.builder()
                .port(8080)
                .protocol("http").build()
                ;
        SeBootstrap.start(MyApplication.class,config).thenAccept(
                instance->{
                    System.out.println(instance);
                URI uri = instance.configuration().baseUri();

                    System.out.println(uri);
                }



        ).exceptionally(ex->{
            System.out.println(ex.getMessage());
            return null;

        });
        Thread.currentThread().join();

    }
}
