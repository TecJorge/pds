package com.example.incenzzoSpringNew.Services;

import com.example.incenzzoSpringNew.Domain.Factory.iLocalFactory;
import com.example.incenzzoSpringNew.Domain.Local;
import com.example.incenzzoSpringNew.Repositorio.LocalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LocalService {
        @Autowired
        iLocalFactory iLocalFactory;

        @Autowired
        LocalRepositorio localRepository;

        public LocalService() {
        }

        public Local createAndSaveLocal(String cidade ,String pais) {

            Local local = iLocalFactory.createandSaveLocal(pais,cidade);
            return localRepository.save(local);
        }


        public List<Local> getAll(){
            return localRepository.getAll();
        }

        public Optional<Local> getLocalByLocalID(int ID) {
            Optional<Local> local = localRepository.findByLocalID(ID);
            return local;
        }
    }

