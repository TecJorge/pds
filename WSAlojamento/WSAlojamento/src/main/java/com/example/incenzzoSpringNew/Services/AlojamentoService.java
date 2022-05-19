package com.example.incenzzoSpringNew.Services;

import com.example.incenzzoSpringNew.DTO.NewLocalInfoDTO;
import com.example.incenzzoSpringNew.DTO.NewTipoAlojamentoInfoDTO;
import com.example.incenzzoSpringNew.Domain.Alojamento;
import com.example.incenzzoSpringNew.Domain.Factory.iAlojamentoFactory;
import com.example.incenzzoSpringNew.Repositorio.AlojamentoRepositorio;
import com.example.incenzzoSpringNew.Repositorio.REST.LocalWebRepository;
import com.example.incenzzoSpringNew.Repositorio.REST.TipoAlojamentoWebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlojamentoService {
    @Autowired
    iAlojamentoFactory iAlojFactory;
    @Autowired
    LocalWebRepository localWebRepository;
    @Autowired
    TipoAlojamentoWebRepository tipoAlojamentoWebRepository;
    @Autowired
    AlojamentoRepositorio AlojamentoRepository;

    public AlojamentoService() {
    }

    public Alojamento createAndSaveAlojamento(int alojamentoID, String denominacao, int tipoAlojamento, int qntmax, int qntmin, double preco,int local,String data) throws Exception {
      Optional<NewTipoAlojamentoInfoDTO> optionalTipoAlojamento= tipoAlojamentoWebRepository.findByCode(String.valueOf(tipoAlojamento));
        Optional<NewLocalInfoDTO> optionalNewLocalInfoDTO= localWebRepository.findByCode(String.valueOf(local));
        if (optionalTipoAlojamento.isPresent()&&optionalNewLocalInfoDTO.isPresent()){
        Alojamento alojamento = iAlojFactory.createandSaveAlojamento(alojamentoID,denominacao,tipoAlojamento,qntmax,qntmin,preco,local,data);
        return AlojamentoRepository.save(alojamento);}
        else
            throw new Exception("Não foi possível criar o Alojamento");
    }


    public List<Alojamento> getAll() throws Exception {
        return AlojamentoRepository.getAll();
    }

    public Optional<Alojamento> getAlojamentoByID(int ID) throws Exception {
        Optional<Alojamento> alojAlojamento = AlojamentoRepository.findByAlojamentoID(ID);
        if(alojAlojamento.isPresent())
        return alojAlojamento;
        else return null;
       // else return Optional.of(lo.toOpt(tipoAlojamentoWebRepository.findByCode(String.valueOf(tipoAlojamentoID)).get()));
    }

}
