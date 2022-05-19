package com.example.incenzzoSpringNew.Repositorio;

import com.example.incenzzoSpringNew.DataModel.Assembler.LocalDomainDataAssembler;
import com.example.incenzzoSpringNew.DataModel.LocalJPA;
import com.example.incenzzoSpringNew.Domain.Local;
import com.example.incenzzoSpringNew.Repositorio.Jpa.LocalJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class LocalRepositorio {

        @Autowired
        LocalJpaRepository localJpaRepositorio;

        @Autowired
        LocalDomainDataAssembler LocalAssembler;

        public Local save(Local local) {
           LocalJPA localJPA = LocalAssembler.toData(local);

           LocalJPA savedLocal = localJpaRepositorio.save(localJPA);

            return LocalAssembler.toDomain(savedLocal);
        }

        public List<Local> getAll() {
            List<LocalJPA> listaLocalJPA = localJpaRepositorio.findAll();
            List<Local> listaLocal= new ArrayList<>();

            for (LocalJPA localJPA : listaLocalJPA) {
                Local local = LocalAssembler.toDomain(localJPA);
                listaLocal.add(local);

            }return listaLocal;
        }
        public Optional<Local> findByLocalID(int ID) {
            Optional<LocalJPA>localJPA = localJpaRepositorio.findByLocalID(ID);
            if (localJPA.isPresent()) {
                Local local = LocalAssembler.toDomain(localJPA.get());
                return Optional.of(local);
            } else {
                return Optional.empty();
            }
        }

}
