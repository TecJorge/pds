package com.example.incenzzoSpringNew.Controller;

import com.example.incenzzoSpringNew.DTO.NewLocalInfoDTO;
import com.example.incenzzoSpringNew.Domain.Local;
import com.example.incenzzoSpringNew.Services.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
@RestController
@RequestMapping(path = "/Local")

public class CriarLocalController {

        @Autowired
        private LocalService service;

        public CriarLocalController(LocalService localService) {
            this.service = localService;
        }

        @GetMapping("")
        @ResponseBody
        public ResponseEntity<Object> getAll() {

            List<Local> locals = service.getAll();

            return new ResponseEntity<>(locals, HttpStatus.OK);
        }

        @GetMapping("/{ID}")
        @ResponseBody
        public ResponseEntity<Object> getById(@PathVariable int ID) {

            Optional<Local> localOptional = service.getLocalByLocalID(ID);

            if( localOptional.isPresent() ) {
                Local local = localOptional.get();
                return new ResponseEntity<>(local, HttpStatus.OK);
            }
            else
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }


        @PostMapping("")
        public ResponseEntity<Object> NewAlojamentoDTO(@RequestBody NewLocalInfoDTO info) {

            Local local = service.createAndSaveLocal(info.getPais(),info.getCidade());

            return new ResponseEntity<>(local, HttpStatus.CREATED);
        }
}
