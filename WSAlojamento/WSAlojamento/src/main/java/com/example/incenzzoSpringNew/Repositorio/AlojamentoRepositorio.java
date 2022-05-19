package com.example.incenzzoSpringNew.Repositorio;

import com.example.incenzzoSpringNew.DataModel.AlojamentoJPA;
import com.example.incenzzoSpringNew.DataModel.Assembler.AlojamentoDomainDataAssembler;
import com.example.incenzzoSpringNew.Domain.Alojamento;
import com.example.incenzzoSpringNew.Repositorio.Jpa.AlojamentoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AlojamentoRepositorio {

        @Autowired
    AlojamentoJpaRepository alojamentoJpaRepositorio;

        @Autowired
        AlojamentoDomainDataAssembler AlojamentoAssembler;

        public Alojamento save(Alojamento Alojamento) throws Exception {
            AlojamentoJPA AlojamentoJPA = AlojamentoAssembler.toData(Alojamento);

            AlojamentoJPA savedALojamento = alojamentoJpaRepositorio.save(AlojamentoJPA);

            return AlojamentoAssembler.toDomain(savedALojamento);
        }

        public List<Alojamento> getAll() throws Exception {
            List<AlojamentoJPA> listaAlojJPA = alojamentoJpaRepositorio.findAll();
            List<Alojamento> listaAloj = new ArrayList<>();

            for (AlojamentoJPA AlojamentoJPA : listaAlojJPA) {
                Alojamento Alojamento = AlojamentoAssembler.toDomain(AlojamentoJPA);
                listaAloj.add(Alojamento);

            }return listaAloj;
        }
    public Optional<Alojamento> findByAlojamentoID(int alojamentoID) throws Exception {
        Optional<AlojamentoJPA> alojamento = alojamentoJpaRepositorio.findByAlojamentoID(alojamentoID);
        if (alojamento.isPresent()) {
            Alojamento Alojamento = AlojamentoAssembler.toDomain(alojamento.get());
            return Optional.of(Alojamento);
        } else {
            return Optional.empty();
        }
    }
}
