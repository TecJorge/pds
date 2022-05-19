package com.example.incenzzoSpringNew.DTO;

import com.example.incenzzoSpringNew.Domain.Local;
import com.example.incenzzoSpringNew.Domain.TipoAlojamento;

import java.util.Objects;

public class NewAlojamentoInfoDTO {

    private int ID;
    private String denominacao;

    private int  tipoAlojamento;

    private String local;

    private int qntdMax,qntdMin;
    private double preco;
    private String data;


    public NewAlojamentoInfoDTO(){}

    public NewAlojamentoInfoDTO(int ID,String name,int tipoAlojamento,int qntmax,int qntdMin,double preco, String local,String data) {
        this.ID=ID;
        this.denominacao=name;
        this.tipoAlojamento=tipoAlojamento;
        this.qntdMax=qntmax;
        this.qntdMin=qntdMin;
        this.preco=preco;
        this.local=local;
        this.data=data;
    }


    public String getDescricao() {
        return denominacao;
    }

    public int getAlojamentoID() {
        return ID;
    }

    public double getPreco() {
        return preco;
    }

    public int getQntdMax() {
        return qntdMax;
    }

    public int getQntdMin() {
        return qntdMin;
    }

    public String getLocal() {
        return local;
    }

    public int getTipoAlojamento() {
        return tipoAlojamento;
    }

    public String getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewAlojamentoInfoDTO that = (NewAlojamentoInfoDTO) o;
        return ID == that.ID && qntdMax == that.qntdMax && qntdMin == that.qntdMin && Double.compare(that.preco, preco) == 0 && Objects.equals(denominacao, that.denominacao) && Objects.equals(tipoAlojamento, that.tipoAlojamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, denominacao, tipoAlojamento, qntdMax, qntdMin, preco);
    }
}
