package com.example.incenzzoSpringNew.Repositorio.Jpa;

import com.example.incenzzoSpringNew.DataModel.AlojamentoJPA;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AlojamentoJpaRepository extends CrudRepository<AlojamentoJPA,Integer> {
    Optional<AlojamentoJPA> findByAlojamentoID(int ID);

    List<AlojamentoJPA> findAll();
}

