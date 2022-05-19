package com.example.incenzzoSpringNew.Domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Id;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

@ToString
@EqualsAndHashCode
public class Alojamento {
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
    public Alojamento(int alojamentoID, String denominacao, int tipoAlojamento, int qntmax, int qntdMin, double preco,int local,String data) throws Exception {
        this.alojamentoID=alojamentoID;
        this.denominacao=denominacao;
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
        ArrayList<String> dayOfWeeks=new ArrayList<>();
        for (DayOfWeek day:DayOfWeek.values()
             ) {dayOfWeeks.add(day.getDisplayName(TextStyle.FULL_STANDALONE,new Locale(System.getProperty("user.country.format"))));
        }
       boolean flag=dayOfWeeks.contains(data.toLowerCase(Locale.ROOT));
        if(data.matches("[0-8]")){
            String sDiaSemana=DayOfWeek.of(Integer.valueOf(data)).getDisplayName(TextStyle.FULL_STANDALONE,new Locale(System.getProperty("user.country.format")));
            return  sDiaSemana.toUpperCase(Locale.ROOT);
        } else if (flag) {
            return data;
        } else throw new Exception("Dia da Semana Invalido");
    }
}
