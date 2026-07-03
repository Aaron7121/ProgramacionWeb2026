package com.programacion.web.servicios.impl;

import com.programacion.web.data.dto.Comment;
import com.programacion.web.repositorios.CommentRepository;
import com.programacion.web.servicios.interfaces.CommentService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CommentServiceImpl implements CommentService {

    final CommentRepository commentRepository;

    @Inject
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> findById(Integer id) {
        return commentRepository.findOptionalBy(id);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void delete(Comment comment) {
        commentRepository.remove(comment);
    }
}