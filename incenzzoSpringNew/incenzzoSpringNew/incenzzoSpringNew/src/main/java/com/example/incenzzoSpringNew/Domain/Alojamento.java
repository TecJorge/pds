package com.example.incenzzoSpringNew.Domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

@ToString
@EqualsAndHashCode
public class Alojamento {
    @Getter
    private int ID;
    @Getter
    private String denominacao;
    @Getter
    private TipoAlojamento tipoAlojamento;
    @Getter
    private Local local;
    @Getter
    private int qntdMax,qntdMin;
    @Getter
    private String data;
    @Getter
    private double preco;
    public Alojamento(int ID, String name, TipoAlojamento tipoAlojamento, int qntmax, int qntdMin, double preco,Local local,String data) throws Exception {
        this.ID=ID;
        this.denominacao=name;
        this.tipoAlojamento=tipoAlojamento;
        this.qntdMax=qntmax;
        this.qntdMin=qntdMin;
        this.preco=preco;
        this.local=local;
        this.data=Traduz(data);
    }
    public Alojamento(){
    }
    private String Traduz(String data) throws Exception {
        if(data.matches("[0-8]")){

            String sDiaSemana=DayOfWeek.of(Integer.valueOf(data)).getDisplayName(TextStyle.FULL_STANDALONE,new Locale(System.getProperty("user.country.format")));
            return  sDiaSemana.toUpperCase(Locale.ROOT);
        }
        else throw new Exception("Dia da Semana Invalido");
    }
}
