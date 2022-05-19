package com.example.incenzzoSpringNew.DataModel.Assembler;

import com.example.incenzzoSpringNew.DataModel.LocalJPA;
import com.example.incenzzoSpringNew.Domain.Local;
import org.springframework.stereotype.Service;
@Service
public class LocalDomainDataAssembler {
        public LocalJPA toData(Local local) {
            LocalJPA localJPA=new LocalJPA(local.getPais(),local.getCidade());
            return localJPA;
        }

        public Local toDomain(LocalJPA localJPA) {
            Local local=new Local(localJPA.getPais(),localJPA.getCidade());
            return local;
        }
    }
