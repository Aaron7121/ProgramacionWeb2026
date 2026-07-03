package com.programacion.web.repositorios;

import com.programacion.web.data.dto.Album;
import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface AlbumRepository extends FullEntityRepository<Album, Integer> {
}