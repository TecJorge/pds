package com.example.incenzzoSpringNew.Controller;


import com.example.incenzzoSpringNew.DTO.NewTipoAlojamentoInfoDTO;
import com.example.incenzzoSpringNew.Domain.TipoAlojamento;
import com.example.incenzzoSpringNew.Services.TipoAlojamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RestController
@RequestMapping(path = "/TipoAlojamento")
public class CriarTipoAlojamentoController {



    //private TipoAlojamento sTipoAlojamento;

    @Autowired
    private TipoAlojamentoService service;

    public CriarTipoAlojamentoController(TipoAlojamentoService service) {
        this.service = service;
    }

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<Object> getAll() {

        List<TipoAlojamento> alojTipoAlojamento = service.getAll();

        return new ResponseEntity<>(alojTipoAlojamento, HttpStatus.OK);
    }

    @GetMapping("/{tipoAlojamentoID}")
    @ResponseBody
    public ResponseEntity<Object> getById(@PathVariable int tipoAlojamentoID) {

        Optional<TipoAlojamento> alojTipoAlojamnto = service.getTipoAlojamentoBytipoAlojamentoID(tipoAlojamentoID);

        if( alojTipoAlojamnto.isPresent() ) {
            TipoAlojamento tipoAlojamento = alojTipoAlojamnto.get();
            return new ResponseEntity<>(tipoAlojamento, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    @PostMapping("")
    public ResponseEntity<Object> NewTipoAlojamentoDTO(@RequestBody NewTipoAlojamentoInfoDTO info) {

        TipoAlojamento tipoAlojamento = service.createAndSaveTipoAlojamento(info.getTipoAlojamentoID(), info.getDescricao());

        return new ResponseEntity<>(tipoAlojamento, HttpStatus.CREATED);
    }


//    public TipoAlojamento getTipoAlojamento() {
//        return sTipoAlojamento;
//    }
//
//    public String getTipoAlojamentoString() {
//        return this.sTipoAlojamento.toString();
//    }
}


