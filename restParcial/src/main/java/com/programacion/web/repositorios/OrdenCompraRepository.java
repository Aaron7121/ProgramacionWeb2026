package com.programacion.web.repositorios;

import com.programacion.web.data.dto.OrdenCompra;
import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface OrdenCompraRepository extends FullEntityRepository<OrdenCompra, Integer> {
}
