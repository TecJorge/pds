package com.example.incenzzoSpringNew.Domain.Factory;

import com.example.incenzzoSpringNew.Domain.TipoAlojamento;
import org.springframework.stereotype.Service;

@Service
public class TipoAlojamentoFactory implements iTipoAlojamentoFactory{


    @Override
    public TipoAlojamento createTipoAlojamento(int tipoAlojamentoID, String descricao) {
        return (new TipoAlojamento(tipoAlojamentoID,descricao));
    }
}
