package com.programacion.web.servicios.impl;

import com.programacion.web.data.dto.User;
import com.programacion.web.repositorios.UserRepository;
import com.programacion.web.servicios.interfaces.UserService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    @Inject
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findOptionalBy(id);
    }

    @Override
    public User save(User user) {

        return userRepository.save(user);
    }

    @Override
    public void remove(User user) {
        userRepository.remove(user);
    }


}