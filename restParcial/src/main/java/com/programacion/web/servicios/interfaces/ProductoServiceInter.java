package com.programacion.web.servicios.interfaces;



import com.programacion.web.data.dto.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoServiceInter {
    List<Producto> findAll();
    Optional<Producto> findById(Integer id);
    Producto save(Producto producto);
    void remove(Producto producto);

}
