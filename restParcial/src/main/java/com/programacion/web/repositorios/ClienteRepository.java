package com.programacion.web.repositorios;


import com.programacion.web.data.dto.Cliente;
import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface ClienteRepository extends FullEntityRepository<Cliente, Integer> {

}
