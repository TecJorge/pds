package com.example.incenzzoSpringNew.Domain.Factory;

import com.example.incenzzoSpringNew.Domain.Alojamento;
import com.example.incenzzoSpringNew.Domain.Local;
import com.example.incenzzoSpringNew.Domain.TipoAlojamento;

public interface iAlojamentoFactory {
    public Alojamento createandSaveAlojamento(int ID, String name, TipoAlojamento tipoAlojamento, int qntmax, int qntdMin, double preco, Local local,String data) throws Exception;
}
