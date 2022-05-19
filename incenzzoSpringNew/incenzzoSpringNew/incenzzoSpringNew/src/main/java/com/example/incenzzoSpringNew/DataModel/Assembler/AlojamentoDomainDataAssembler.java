package com.example.incenzzoSpringNew.DataModel.Assembler;

import com.example.incenzzoSpringNew.DataModel.AlojamentoJPA;
import com.example.incenzzoSpringNew.DataModel.LocalJPA;
import com.example.incenzzoSpringNew.DataModel.TipoAlojamentoJPA;
import com.example.incenzzoSpringNew.Domain.Alojamento;
import com.example.incenzzoSpringNew.Domain.Local;
import com.example.incenzzoSpringNew.Domain.TipoAlojamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlojamentoDomainDataAssembler {
    @Autowired
    TipoAlojamentoDomainDataAssembler tipoAlojamentoDomainDataAssembler;
    @Autowired
    LocalDomainDataAssembler localDomainDataAssembler;
    public AlojamentoJPA toData(Alojamento Alojamento) throws Exception {
        LocalJPA localJPA=localDomainDataAssembler.toData(Alojamento.getLocal());
        TipoAlojamentoJPA tipoAlojamentoJPA=tipoAlojamentoDomainDataAssembler.toData(Alojamento.getTipoAlojamento());
        return new AlojamentoJPA(Alojamento.getID(),Alojamento.getDenominacao(),tipoAlojamentoJPA,Alojamento.getQntdMax(),Alojamento.getQntdMin(),Alojamento.getPreco(),localJPA,Alojamento.getData());
    }

    public Alojamento toDomain(AlojamentoJPA Alojamento) throws Exception {
        Local local=localDomainDataAssembler.toDomain(Alojamento.getLocal());
        TipoAlojamento tipoAlojamento=tipoAlojamentoDomainDataAssembler.toDomain(Alojamento.getTipoAlojamento());
        return new Alojamento(Alojamento.getAlojamentoID(),Alojamento.getDenominacao(),tipoAlojamento, Alojamento.getQntdMax(),Alojamento.getQntdMin(),Alojamento.getPreco(),local,Alojamento.getData());
    }
}
