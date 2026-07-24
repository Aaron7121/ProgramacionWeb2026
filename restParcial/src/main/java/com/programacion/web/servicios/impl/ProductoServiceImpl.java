package com.programacion.web.servicios.impl;


import com.programacion.web.data.dto.Producto;
import com.programacion.web.repositorios.ProductoRepository;
import com.programacion.web.servicios.interfaces.ProductoServiceInter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductoServiceImpl implements ProductoServiceInter {

    final ProductoRepository productoRepository;

    @Inject
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }


    public List<Producto> filtroDinamico(double precio,String nombre) {

       return productoRepository.listarProductoFiltro(precio,nombre).getResultList();


    }


    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Integer id) {
        return productoRepository.findOptionalBy(id);
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }



    @Override
    public void remove(Producto producto) {
        productoRepository.remove(producto);
    }
}
