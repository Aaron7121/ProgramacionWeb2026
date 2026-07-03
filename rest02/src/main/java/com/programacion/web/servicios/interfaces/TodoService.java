package com.programacion.web.servicios.interfaces;

import com.programacion.web.data.dto.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    List<Todo> findAll();
    Optional<Todo> findById(Integer id);
    Todo save(Todo user);
    void remove(Todo user);

}