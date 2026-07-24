package com.programacion.web.repositorios;

import com.programacion.web.data.dto.Producto;
import org.apache.deltaspike.data.api.*;

import java.util.List;

@Repository
public interface ProductoRepository extends FullEntityRepository<Producto, Integer> {

    @Query("SELECT p FROM Producto p WHERE " +
            "(:precio IS NULL OR p.precio = :precio) AND" +
            " (:nombre IS NULL OR p.nombre = :nombre)"

    )
     QueryResult<Producto> listarProductoFiltro (@QueryParam("precio") double precio,@QueryParam("nombre")String nombre);
}
