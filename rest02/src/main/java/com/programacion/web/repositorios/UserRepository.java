package com.programacion.web.repositorios;


import com.programacion.web.data.dto.User;
import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface UserRepository extends FullEntityRepository<User, Integer> {


}