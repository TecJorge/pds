package com.example.incenzzoSpringNew.Controller;

import com.example.incenzzoSpringNew.DTO.NewAlojamentoInfoDTO;
import com.example.incenzzoSpringNew.Domain.Alojamento;
import com.example.incenzzoSpringNew.Domain.Local;
import com.example.incenzzoSpringNew.Domain.TipoAlojamento;
import com.example.incenzzoSpringNew.Services.AlojamentoService;
import com.example.incenzzoSpringNew.Services.LocalService;
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
@RequestMapping(path = "/Alojamento")
public class CriarAlojamentoController {

        @Autowired
        private AlojamentoService service;
        @Autowired
        private TipoAlojamentoService tipoAlojamentoService;
        @Autowired
        private LocalService localService;

        public CriarAlojamentoController(AlojamentoService alojamentoService) {
            this.service = alojamentoService;
        }

        @GetMapping("")
        @ResponseBody
        public ResponseEntity<Object> getAll() throws Exception {

            List<Alojamento> alojAlojamento = service.getAll();

            return new ResponseEntity<>(alojAlojamento, HttpStatus.OK);
        }

        @GetMapping("/{code}")
        @ResponseBody
        public ResponseEntity<Object> getById(@PathVariable int ID) throws Exception {

            Optional<Alojamento> alojamento = service.getAlojamentoByAlojamentoID(ID);

            if( alojamento.isPresent() ) {
                Alojamento Alojamento = alojamento.get();
                return new ResponseEntity<>(Alojamento, HttpStatus.OK);
            }
            else
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }


        @PostMapping("")
        public ResponseEntity<Object> NewAlojamentoDTO(@RequestBody NewAlojamentoInfoDTO info) throws Exception {
            try {


            Alojamento Alojamento = service.createAndSaveAlojamento(info.getAlojamentoID(),info.getDescricao(),info.getTipoAlojamento(),info.getQntdMax(), info.getQntdMin(),info.getPreco(),info.getLocal(),info.getData());
            return new ResponseEntity<>(Alojamento, HttpStatus.CREATED);}
            catch (Exception e){
                return new ResponseEntity<>(e.getMessage(),HttpStatus.NO_CONTENT);
        }}
}
