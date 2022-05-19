package com.example.incenzzoSpringNew.DataModel;

import com.example.incenzzoSpringNew.Domain.Local;
import lombok.Getter;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

@Entity
@Table(name="Alojamento")
public class AlojamentoJPA {
    @Id
    @Getter
    private int alojamentoID;
    @Getter
    private String denominacao;
    @Getter
    @ManyToOne
    @JoinColumn(name = "TipoAlojamento")
    private TipoAlojamentoJPA tipoAlojamento;
    @Getter
    @ManyToOne
    @JoinColumn(name="Local")
    private LocalJPA local;
    @Getter
    private int qntdMax,qntdMin;
    @Getter
    private String data;
    @Getter
    private double preco;

    public AlojamentoJPA(){}

    public AlojamentoJPA(int ID,String name,TipoAlojamentoJPA tipoAlojamento,int qntmax,int qntdMin,double preco,LocalJPA local,String Data) throws Exception {
        this.alojamentoID=ID;
        this.denominacao=name;
        this.tipoAlojamento=tipoAlojamento;
        this.qntdMax=qntmax;
        this.qntdMin=qntdMin;
        this.preco=preco;
        this.local=local;
        this.data=Traduz(data);
    }

    public void setTipoAlojamento(TipoAlojamentoJPA tipoAlojamento) {
        this.tipoAlojamento = tipoAlojamento;
    }

    private String Traduz(String data) throws Exception {
        if(data.matches("[0<8]")){
            return DayOfWeek.valueOf(data).getDisplayName(TextStyle.FULL_STANDALONE,new Locale(System.getProperty("user.country.format")));
        }
        else throw new Exception("Dia da Semana Invalido");
    }
}

