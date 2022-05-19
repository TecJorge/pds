package com.example.incenzzoSpringNew.Repositorio.Jpa;

import com.example.incenzzoSpringNew.DataModel.LocalJPA;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LocalJpaRepository extends CrudRepository<LocalJPA,Integer> {
    Optional<LocalJPA> findByLocalID(int ID);

    List<LocalJPA> findAll();
}
