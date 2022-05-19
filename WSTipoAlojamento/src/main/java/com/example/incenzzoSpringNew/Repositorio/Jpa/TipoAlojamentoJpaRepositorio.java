package com.example.incenzzoSpringNew.Repositorio.Jpa;

import com.example.incenzzoSpringNew.DataModel.TipoAlojamentoJPA;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TipoAlojamentoJpaRepositorio extends CrudRepository<TipoAlojamentoJPA, Integer> {

    Optional<TipoAlojamentoJPA> findBytipoAlojamentoID(int tipoAlojamentoID);

    List<TipoAlojamentoJPA> findAll();
}
