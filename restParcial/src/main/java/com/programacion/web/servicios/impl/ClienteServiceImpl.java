package com.programacion.web.servicios.impl;


import com.programacion.web.data.dto.Cliente;
import com.programacion.web.repositorios.ClienteRepository;
import com.programacion.web.servicios.interfaces.ClienteServiceInter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteServiceInter {


    final ClienteRepository clienteRepo;

    @Inject
    public ClienteServiceImpl(ClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
    }
    @Override
    public List<Cliente> findAll() {


        return clienteRepo.findAll();
    }

    @Override
    public Optional<Cliente> findById(Integer id) {
        return clienteRepo.findOptionalBy(id);
    }



    @Override
    public Cliente save(Cliente cliente) {

        return clienteRepo.save(cliente);
    }



    @Override
    public void remove(Cliente cliente) {
            clienteRepo.remove(cliente);

    }

}
