package com.programacion.web.servicios.interfaces;


import com.programacion.web.data.dto.OrdenCompra;

import java.util.List;
import java.util.Optional;

public interface OrdenCompraServiceInter {
    List<OrdenCompra> findAll();
    Optional<OrdenCompra> findById(Integer id);
    OrdenCompra save(OrdenCompra ordenCompra);
    void remove(OrdenCompra ordenCompra);


}
