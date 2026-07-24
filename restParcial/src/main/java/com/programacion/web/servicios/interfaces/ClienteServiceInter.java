package com.programacion.web.servicios.interfaces;



import com.programacion.web.data.dto.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteServiceInter {

    List<Cliente> findAll();
    Optional<Cliente> findById(Integer id);
    Cliente save(Cliente cliente);
  //  Cliente update(Cliente user,Integer id);
    void remove(Cliente cliente);

}
