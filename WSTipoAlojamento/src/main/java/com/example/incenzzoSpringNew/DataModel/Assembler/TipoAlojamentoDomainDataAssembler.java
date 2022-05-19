package com.example.incenzzoSpringNew.DataModel.Assembler;

import com.example.incenzzoSpringNew.DTO.NewTipoAlojamentoInfoDTO;
import com.example.incenzzoSpringNew.DataModel.TipoAlojamentoJPA;
import com.example.incenzzoSpringNew.Domain.TipoAlojamento;
import org.springframework.stereotype.Service;

@Service
public class TipoAlojamentoDomainDataAssembler {

    public TipoAlojamentoJPA toData(TipoAlojamento tipoAlojamento) {
        return new TipoAlojamentoJPA(tipoAlojamento.getDescricao(), tipoAlojamento.getTipoAlojamentoID());
    }

    public TipoAlojamento toDomain(TipoAlojamentoJPA tipoAlojamento) {
        return new TipoAlojamento(tipoAlojamento.getTipoAlojamentoID(), tipoAlojamento.getDescricao());
    }
    public TipoAlojamento toOpt(NewTipoAlojamentoInfoDTO tipoAlojamentoInfoDTO){
        return new TipoAlojamento(tipoAlojamentoInfoDTO.getTipoAlojamentoID(),tipoAlojamentoInfoDTO.getDescricao());
    }

}
