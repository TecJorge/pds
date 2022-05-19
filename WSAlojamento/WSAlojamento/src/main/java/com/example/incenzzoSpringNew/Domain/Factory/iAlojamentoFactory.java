package com.example.incenzzoSpringNew.Domain.Factory;

import com.example.incenzzoSpringNew.Domain.Alojamento;

public interface iAlojamentoFactory {
    Alojamento createandSaveAlojamento(int alojamentoID, String denominacao, int tipoAlojamento, int qntmax, int qntdMin, double preco, int local,String data) throws Exception;
}
