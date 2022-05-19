package com.example.incenzzoSpringNew.Domain.Factory;

import com.example.incenzzoSpringNew.Domain.TipoAlojamento;

public interface iTipoAlojamentoFactory {

      TipoAlojamento createTipoAlojamento (int tipoAlojamentoID,String descricao);

    }
