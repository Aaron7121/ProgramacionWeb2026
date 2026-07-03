package com.programacion.web.servicios.impl;


import com.programacion.web.data.dto.Todo;
import com.programacion.web.repositorios.TodoRepository;
import com.programacion.web.servicios.interfaces.TodoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Inject
    public TodoServiceImpl(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }


    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Optional<Todo> findById(Integer id) {
        return todoRepository.findOptionalBy(id);
    }

    @Override
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void remove(Todo todo) {
        todoRepository.remove(todo);
    }
}