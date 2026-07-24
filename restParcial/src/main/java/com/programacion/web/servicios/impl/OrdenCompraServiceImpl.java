package com.programacion.web.servicios.impl;


import com.programacion.web.data.dto.OrdenCompra;
import com.programacion.web.repositorios.ClienteRepository;
import com.programacion.web.repositorios.OrdenCompraRepository;
import com.programacion.web.repositorios.ProductoRepository;
import com.programacion.web.servicios.interfaces.OrdenCompraServiceInter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrdenCompraServiceImpl implements OrdenCompraServiceInter {

    final OrdenCompraRepository ordenCompraRepository;
    final ClienteRepository clienteRepository;

    final ClienteServiceImpl clienteServiceImpl;
    final ProductoRepository productoRepository;

    final ProductoServiceImpl productoServiceImpl;

    @Inject
    public OrdenCompraServiceImpl(ProductoServiceImpl productoServiceImpl,ClienteServiceImpl clienteServiceImpl,ClienteRepository clienteRepo, ProductoRepository productoRepository, OrdenCompraRepository ordenCompraRepository) {
        this.ordenCompraRepository = ordenCompraRepository;
        this.clienteRepository = clienteRepo;
        this.productoRepository = productoRepository;
        this.clienteServiceImpl = clienteServiceImpl;
        this.productoServiceImpl = productoServiceImpl;
    }
    @Override
    public List<OrdenCompra> findAll() {
        return ordenCompraRepository.findAll();
    }

    @Override
    public Optional<OrdenCompra> findById(Integer id) {
        return ordenCompraRepository.findOptionalBy(id);
    }

    @Override
    public OrdenCompra save(OrdenCompra ordenCompra) {
        var manageCliente = clienteRepository.findBy(ordenCompra.getCliente().getId());
        var manageProducto = ordenCompra.getProductos().stream()
                .map((producto)-> productoRepository.findBy(producto.getId())).toList();
        ordenCompra.setCliente(manageCliente);
        ordenCompra.setProductos(manageProducto);
        return ordenCompraRepository.save(ordenCompra);
    }

    @Override
    public void remove(OrdenCompra ordenCompra) {
        ordenCompraRepository.remove(ordenCompra);
    }
}
