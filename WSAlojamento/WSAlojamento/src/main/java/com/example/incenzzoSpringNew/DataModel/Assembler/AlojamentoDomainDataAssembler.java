package com.example.incenzzoSpringNew.DataModel.Assembler;

import com.example.incenzzoSpringNew.DataModel.AlojamentoJPA;
import com.example.incenzzoSpringNew.Domain.Alojamento;
import org.springframework.stereotype.Service;

@Service
public class AlojamentoDomainDataAssembler {
    public AlojamentoJPA toData(Alojamento Alojamento) throws Exception {
        return new AlojamentoJPA(Alojamento.getAlojamentoID(),Alojamento.getDenominacao(), Alojamento.getTipoAlojamento(), Alojamento.getQntdMax(),Alojamento.getQntdMin(),Alojamento.getPreco(), Alojamento.getLocal(), Alojamento.getData());
    }

    public Alojamento toDomain(AlojamentoJPA Alojamento) throws Exception {
        return new Alojamento(Alojamento.getAlojamentoID(),Alojamento.getDenominacao(), Alojamento.getTipoAlojamento(), Alojamento.getQntdMax(),Alojamento.getQntdMin(),Alojamento.getPreco(),Alojamento.getLocal(),Alojamento.getData());
    }
}
