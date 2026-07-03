package com.programacion.web.servicios.interfaces;
import com.programacion.web.data.dto.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumService {

    List<Album> findAll();
    Optional<Album> findById(Integer id);
    Album save(Album album);
    void delete(Album album);

}