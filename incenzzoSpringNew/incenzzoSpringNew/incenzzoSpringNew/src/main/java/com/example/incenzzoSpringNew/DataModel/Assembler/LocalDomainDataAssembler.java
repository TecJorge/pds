package com.example.incenzzoSpringNew.DataModel.Assembler;

import com.example.incenzzoSpringNew.DTO.NewLocalInfoDTO;
import com.example.incenzzoSpringNew.DataModel.AlojamentoJPA;
import com.example.incenzzoSpringNew.DataModel.LocalJPA;
import com.example.incenzzoSpringNew.DataModel.TipoAlojamentoJPA;
import com.example.incenzzoSpringNew.Domain.Alojamento;
import com.example.incenzzoSpringNew.Domain.Local;
import com.example.incenzzoSpringNew.Domain.TipoAlojamento;
import org.springframework.beans.factory.annotation.Autowired;
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
        public Local toOpt(NewLocalInfoDTO localInfoDTO){
            return new Local(localInfoDTO.getPais(),localInfoDTO.getCidade());
        }
    }
