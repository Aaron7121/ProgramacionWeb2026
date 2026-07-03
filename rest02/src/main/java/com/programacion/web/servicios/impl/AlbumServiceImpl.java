package com.programacion.web.servicios.impl;

import com.programacion.web.data.dto.Album;
import com.programacion.web.repositorios.AlbumRepository;
import com.programacion.web.servicios.interfaces.AlbumService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AlbumServiceImpl implements AlbumService {

    final AlbumRepository albumRepository;

    @Inject
    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Optional<Album> findById(Integer id) {
        return albumRepository.findOptionalBy(id);
    }

    @Override
    public Album save(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public void delete(Album album) {
        albumRepository.remove(album);
    }
}