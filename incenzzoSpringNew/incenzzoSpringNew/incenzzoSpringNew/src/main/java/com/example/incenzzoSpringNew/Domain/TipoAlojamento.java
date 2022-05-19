package com.example.incenzzoSpringNew.Domain;

import com.example.incenzzoSpringNew.DTO.NewTipoAlojamentoInfoDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class TipoAlojamento {


    @Getter
    private int tipoAlojamentoID;
    @Getter
    private String descricao;




    //Do Later
//    @Getter
//    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    public TipoAlojamento(int tipoAlojamentoID,String descricao) {
        this.tipoAlojamentoID= tipoAlojamentoID;
        this.descricao = descricao;

    }
    public TipoAlojamento(){
    }
}

//    @Override
//    public String toString() {
//        return String.format("Descrição do tipo de Alojamento: %s\n", descricao);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o)
//            return true;
//        if (!(o instanceof TipoAlojamento))
//            return false;
//        TipoAlojamento that = (TipoAlojamento) o;
//        return Objects.equals(descricao, that.descricao);
//    }

