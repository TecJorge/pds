package com.example.incenzzoSpringNew.Domain.Factory;

import com.example.incenzzoSpringNew.Domain.Alojamento;
import org.springframework.stereotype.Service;

@Service
public class AlojamentoFactory implements iAlojamentoFactory{
    @Override
    public Alojamento createandSaveAlojamento(int alojamentoID, String denominacao, int tipoAlojamento, int qntmax, int qntdMin, double preco, int local,String data) throws Exception {
        return new Alojamento(alojamentoID,denominacao,tipoAlojamento,qntmax,qntdMin,preco,local,data);
    }

}
