package com.programacion.web.servicios.interfaces;

import com.programacion.web.data.dto.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> findAll();
    Optional<Post> findById(Integer id);
    Post create(Post post); // Para crear nuevos Posts
    Post save(Post post);   // Para actualizar Posts existentes
    void delete(Post post);

}