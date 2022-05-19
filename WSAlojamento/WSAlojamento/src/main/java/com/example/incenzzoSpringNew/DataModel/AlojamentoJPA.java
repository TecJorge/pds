package com.example.incenzzoSpringNew.DataModel;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Alojamento")
public class AlojamentoJPA {
    @Id
    @Getter
    private int alojamentoID;
    @Getter
    private String denominacao;
    @Getter
    private int tipoAlojamento;
    @Getter
    private int local;
    @Getter
    private int qntdMax,qntdMin;
    @Getter
    private String data;
    @Getter
    private double preco;

    public AlojamentoJPA(){}

    public AlojamentoJPA(int alojamentoID,String denominacao,int tipoAlojamento,int qntmax,int qntdMin,double preco,int local,String data) throws Exception {
        this.alojamentoID=alojamentoID;
        this.denominacao=denominacao;
        this.tipoAlojamento=tipoAlojamento;
        this.qntdMax=qntmax;
        this.qntdMin=qntdMin;
        this.preco=preco;
        this.local=local;
        this.data=data;
    }

}

