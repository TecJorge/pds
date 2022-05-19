package com.example.incenzzoSpringNew.Repositorio;


import com.example.incenzzoSpringNew.DataModel.Assembler.TipoAlojamentoDomainDataAssembler;
import com.example.incenzzoSpringNew.DataModel.TipoAlojamentoJPA;
import com.example.incenzzoSpringNew.Domain.TipoAlojamento;
import com.example.incenzzoSpringNew.Repositorio.Jpa.TipoAlojamentoJpaRepositorio;
import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TipoAlojamentoRepositorio {

    @Autowired
    TipoAlojamentoJpaRepositorio tipoAlojamentoJpaRepositorio;

    @Autowired
    TipoAlojamentoDomainDataAssembler tipoAlojamentoAssembler;

    public TipoAlojamento save(TipoAlojamento tipoAlojamento) {
        TipoAlojamentoJPA tipoAlojamentoJPA = tipoAlojamentoAssembler.toData(tipoAlojamento);

        TipoAlojamentoJPA savedTipoALojamento = tipoAlojamentoJpaRepositorio.save(tipoAlojamentoJPA);

        return tipoAlojamentoAssembler.toDomain(savedTipoALojamento);
    }

    public List<TipoAlojamento> getAll() {
        List<TipoAlojamentoJPA> listaTipoAlojJPA = tipoAlojamentoJpaRepositorio.findAll();
        List<TipoAlojamento> listaTipoAloj = new ArrayList<>();

        for (TipoAlojamentoJPA tipoAlojamentoJPA : listaTipoAlojJPA) {
            TipoAlojamento tipoAlojamento = tipoAlojamentoAssembler.toDomain(tipoAlojamentoJPA);
            listaTipoAloj.add(tipoAlojamento);

        }return listaTipoAloj;
    }


    public Optional<TipoAlojamento> findBytipoAlojamentoID(int tipoAlojamentoID) {
        Optional<TipoAlojamentoJPA> alojTipoAlojamento = tipoAlojamentoJpaRepositorio.findBytipoAlojamentoID(tipoAlojamentoID);
        if (alojTipoAlojamento.isPresent()) {
            TipoAlojamento tipoAlojamento = tipoAlojamentoAssembler.toDomain(alojTipoAlojamento.get());
            return Optional.of(tipoAlojamento);
        } else {
            return Optional.empty();
        }
    }
}
