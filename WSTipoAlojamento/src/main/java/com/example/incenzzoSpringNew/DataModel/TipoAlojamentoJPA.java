package com.example.incenzzoSpringNew.DataModel;


import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TiposAlojamento")
public class TipoAlojamentoJPA {

//     Do Later
////    @Id
////    @Getter
//    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1);
    @Id
    @Getter
    private int tipoAlojamentoID;
    @Getter
    private String descricao;

    public TipoAlojamentoJPA() {
    }

    public TipoAlojamentoJPA(String descricao,int id){
        this.tipoAlojamentoID=id;
        this.descricao = descricao;
    }

}
