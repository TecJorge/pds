package com.example.incenzzoSpringNew.DTO;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class NewTipoAlojamentoInfoDTO {

    int tipoAlojamentoID;
    String descricao;

    static AtomicInteger ID_GENERATOR = new AtomicInteger(1);


    public NewTipoAlojamentoInfoDTO(){}

    public NewTipoAlojamentoInfoDTO(int tipoAlojamentoID, String descricao) {
        this.tipoAlojamentoID = ID_GENERATOR.incrementAndGet();
        this.descricao = descricao;
    }


    public String getDescricao() {
        return descricao;
    }

    public int getTipoAlojamentoID() {
        return tipoAlojamentoID;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewTipoAlojamentoInfoDTO)) return false;
        NewTipoAlojamentoInfoDTO that = (NewTipoAlojamentoInfoDTO) o;
        return tipoAlojamentoID == that.tipoAlojamentoID && descricao.equals(that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, tipoAlojamentoID);
    }
}
