package com.programacion.web.servicios.interfaces;

import com.programacion.web.data.dto.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    List<Comment> findAll();
    Optional<Comment> findById(Integer id);
    Comment save(Comment comment);
    void delete(Comment comment);

}