package com.programacion.web.servicios.impl;

import com.programacion.web.data.dto.Post;
import com.programacion.web.repositorios.PostRepository;
import com.programacion.web.servicios.interfaces.PostService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PostServiceImpl implements PostService {

    final PostRepository postRepository;

    @Inject
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Integer id) {
        return postRepository.findOptionalBy(id);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void delete(Post post) {
        postRepository.remove(post);
    }
}