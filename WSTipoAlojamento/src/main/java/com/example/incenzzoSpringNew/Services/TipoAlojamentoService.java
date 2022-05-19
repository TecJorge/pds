package com.example.incenzzoSpringNew.Services;

import com.example.incenzzoSpringNew.DTO.NewTipoAlojamentoInfoDTO;
import com.example.incenzzoSpringNew.DataModel.Assembler.TipoAlojamentoDomainDataAssembler;
import com.example.incenzzoSpringNew.Domain.Factory.iTipoAlojamentoFactory;
import com.example.incenzzoSpringNew.Domain.TipoAlojamento;
import com.example.incenzzoSpringNew.Repositorio.REST.TipoAlojamentoWebRepository;
import com.example.incenzzoSpringNew.Repositorio.TipoAlojamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TipoAlojamentoService {

    @Autowired
    iTipoAlojamentoFactory iTipoAlojFactory;

    @Autowired
    TipoAlojamentoRepositorio tipoAlojamentoRepositorio;
    @Autowired
    TipoAlojamentoWebRepository tipoAlojamentoWebRepository;
    @Autowired
    TipoAlojamentoDomainDataAssembler tipoAlojamentoDomainDataAssembler;

    public TipoAlojamentoService() {
    }

    public TipoAlojamento createAndSaveTipoAlojamento(int tipoAlojamentoID,String descricao) {

        TipoAlojamento tipoAlojamento = iTipoAlojFactory.createTipoAlojamento(tipoAlojamentoID, descricao);
        return tipoAlojamentoRepositorio.save(tipoAlojamento);
    }


    public List<TipoAlojamento> getAll(){
        return tipoAlojamentoRepositorio.getAll();
    }

    public Optional<TipoAlojamento> getTipoAlojamentoBytipoAlojamentoID(int tipoAlojamentoID) {

        Optional<TipoAlojamento> alojTipoAlojamento = tipoAlojamentoRepositorio.findBytipoAlojamentoID(tipoAlojamentoID);
        if(alojTipoAlojamento.isPresent())
        return alojTipoAlojamento;
        else

        return Optional.of(tipoAlojamentoDomainDataAssembler.toOpt(tipoAlojamentoWebRepository.findByCode(String.valueOf(tipoAlojamentoID)).get()));
    }
}
