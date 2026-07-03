package com.programacion.web.servicios.interfaces;

import com.programacion.web.data.dto.Photo;

import java.util.List;
import java.util.Optional;

public interface PhotoService {

    List<Photo> findAll();
    Optional<Photo> findById(Integer id);
    Photo save(Photo photo);
    void delete(Photo photo);

}