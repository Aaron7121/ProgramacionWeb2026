package com.programacion.web.repositorios;

import com.programacion.web.data.dto.Post;
import com.programacion.web.data.dto.Todo;
import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.jboss.logging.annotations.Pos;

@Repository
public interface TodoRepository extends FullEntityRepository<Todo, Integer> {
}