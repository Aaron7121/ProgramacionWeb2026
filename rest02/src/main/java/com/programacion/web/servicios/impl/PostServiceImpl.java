package com.programacion.web.servicios.impl;

import com.programacion.web.data.dto.Post;
import com.programacion.web.data.dto.User;
import com.programacion.web.repositorios.PostRepository;
import com.programacion.web.repositorios.UserRepository;
import com.programacion.web.servicios.interfaces.PostService;
import com.programacion.web.servicios.interfaces.UserService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PostServiceImpl implements PostService {


    final UserRepository userRepository;
    final PostRepository postRepository;

    @Inject
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
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
        // Este método es para actualizar Posts existentes
        User managedUser = userRepository.findBy(post.getUser().getId());
        if (managedUser == null) {
            throw new IllegalArgumentException("User with ID " + post.getUser().getId() + " does not exist");
        }
        post.setUser(managedUser);
        return postRepository.merge(post);
    }

    public Post create(Post post) {
        // Este método es para crear nuevos Posts
        User managedUser = userRepository.findBy(post.getUser().getId());
        if (managedUser == null) {
            throw new IllegalArgumentException("User with ID " + post.getUser().getId() + " does not exist");
        }
        // Asegurar que el nuevo post no tiene ID (para evitar conflictos)

        post.setUser(managedUser);
        postRepository.persist(post);
        return post;
    }

    @Override
    public void delete(Post post) {
        postRepository.remove(post);
    }
}