package com.example.incenzzoSpringNew.Domain.Factory;

import com.example.incenzzoSpringNew.Domain.Alojamento;
import com.example.incenzzoSpringNew.Domain.Local;
import com.example.incenzzoSpringNew.Domain.TipoAlojamento;
import org.springframework.stereotype.Service;

@Service
public class AlojamentoFactory implements iAlojamentoFactory{
    @Override
    public Alojamento createandSaveAlojamento(int ID, String name, TipoAlojamento tipoAlojamento, int qntmax, int qntdMin, double preco, Local local,String data) throws Exception {
        return new Alojamento(ID,name,tipoAlojamento,qntmax,qntdMin,preco,local,data);
    }

}
