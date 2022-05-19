package com.example.incenzzoSpringNew.Domain.Factory;

import com.example.incenzzoSpringNew.Domain.Local;
import org.springframework.stereotype.Service;

@Service
public class LocalFactory implements iLocalFactory {

    @Override
    public Local createandSaveLocal(String pais, String cidade) {
        return new Local(pais,cidade);
    }
}
