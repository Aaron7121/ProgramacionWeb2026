package com.programacion.web.repositorios;

import com.programacion.web.data.dto.Photo;
import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface PhotoRepository extends FullEntityRepository<Photo, Integer> {
}