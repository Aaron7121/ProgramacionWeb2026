package dto;

import jakarta.ws.rs.Path;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Customer {


    private Integer id;
    private String name;
    private String direccion;




}
