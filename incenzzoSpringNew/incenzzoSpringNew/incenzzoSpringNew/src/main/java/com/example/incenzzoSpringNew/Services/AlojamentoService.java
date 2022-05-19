package com.example.incenzzoSpringNew.Services;

import com.example.incenzzoSpringNew.Domain.Alojamento;
import com.example.incenzzoSpringNew.Domain.Factory.iAlojamentoFactory;
import com.example.incenzzoSpringNew.Domain.Local;
import com.example.incenzzoSpringNew.Domain.TipoAlojamento;
import com.example.incenzzoSpringNew.Repositorio.AlojamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlojamentoService {
    @Autowired
    iAlojamentoFactory iAlojFactory;
    @Autowired
    LocalService localService;
    @Autowired
    TipoAlojamentoService tipoAlojamentoService;
    @Autowired
    AlojamentoRepositorio AlojamentoRepository;

    public AlojamentoService() {
    }

    public Alojamento createAndSaveAlojamento(int ID, String descricao, int tipoAlojamento, int qntmax, int qntmin, double preco,String local,String data) throws Exception {
        Optional<TipoAlojamento> optionalTipoAlojamento=tipoAlojamentoService.getTipoAlojamentoBytipoAlojamentoID(tipoAlojamento);
        Optional<Local> optionalLocal = localService.getLocalByLocalID(Integer.valueOf(local));
        if (optionalTipoAlojamento.isPresent()&&optionalLocal.isPresent()){
           TipoAlojamento tempTipoAlojamento=optionalTipoAlojamento.get();
            Local templocal=optionalLocal.get();
        Alojamento alojamento = iAlojFactory.createandSaveAlojamento(ID,descricao,tempTipoAlojamento,qntmax,qntmin,preco,templocal,data);
        return AlojamentoRepository.save(alojamento);}
        else
            throw new Exception("Não foi possível criar o Alojamento");
    }


    public List<Alojamento> getAll() throws Exception {
        return AlojamentoRepository.getAll();
    }

    public Optional<Alojamento> getAlojamentoByAlojamentoID(int ID) throws Exception {
        Optional<Alojamento> alojAlojamento = AlojamentoRepository.findByAlojamentoID(ID);
        if(alojAlojamento.isPresent())
        return alojAlojamento;
        else return null;
       // else return Optional.of(lo.toOpt(tipoAlojamentoWebRepository.findByCode(String.valueOf(tipoAlojamentoID)).get()));
    }
}
