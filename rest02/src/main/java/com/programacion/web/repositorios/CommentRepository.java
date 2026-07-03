package com.programacion.web.repositorios;

import com.programacion.web.data.dto.Comment;
import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface CommentRepository extends FullEntityRepository<Comment, Integer> {
}