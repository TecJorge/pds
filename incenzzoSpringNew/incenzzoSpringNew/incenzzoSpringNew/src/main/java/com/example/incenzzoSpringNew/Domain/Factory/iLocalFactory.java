package com.example.incenzzoSpringNew.Domain.Factory;

import com.example.incenzzoSpringNew.Domain.Local;
import com.example.incenzzoSpringNew.Domain.TipoAlojamento;

public interface iLocalFactory {
    public Local createandSaveLocal(String pais,String cidade);
}

