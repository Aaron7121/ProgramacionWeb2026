package com.programacion.web.servicios.impl;

import com.programacion.web.data.dto.Photo;
import com.programacion.web.repositorios.PhotoRepository;
import com.programacion.web.servicios.interfaces.PhotoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PhotoServiceImpl implements PhotoService {

    final PhotoRepository photoRepository;

    @Inject
    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public List<Photo> findAll() {
        return photoRepository.findAll();
    }

    @Override
    public Optional<Photo> findById(Integer id) {
        return photoRepository.findOptionalBy(id);
    }

    @Override
    public Photo save(Photo photo) {
        return photoRepository.save(photo);
    }

    @Override
    public void delete(Photo photo) {
        photoRepository.remove(photo);
    }
}