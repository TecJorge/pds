package com.example.incenzzoSpringNew.DTO;

import java.util.Objects;

public class NewAlojamentoInfoDTO {

    private int alojamentoID;
    private String denominacao;

    private int  tipoAlojamento;

    private int local;

    private int qntdMax,qntdMin;
    private double preco;
    private String data;


    public NewAlojamentoInfoDTO(){}

    public NewAlojamentoInfoDTO(int alojamentoID,String denominacao,int tipoAlojamento,int qntmax,int qntdMin,double preco, int local,String data) {
        this.alojamentoID=alojamentoID;
        this.denominacao=denominacao;
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

    public int getID() {
        return alojamentoID;
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

    public int getLocal() {
        return local;
    }

    public int getTipoAlojamento() {
        return tipoAlojamento;
    }

    public String getData() {
        return data;
    }

    public void setAlojamentoID(int alojamentoID) {
        this.alojamentoID = alojamentoID;
    }

    public void setDenominacao(String denominacao) {
        this.denominacao = denominacao;
    }

    public void setTipoAlojamento(int tipoAlojamento) {
        this.tipoAlojamento = tipoAlojamento;
    }

    public void setLocal(int local) {
        this.local = local;
    }

    public void setQntdMax(int qntdMax) {
        this.qntdMax = qntdMax;
    }

    public void setQntdMin(int qntdMin) {
        this.qntdMin = qntdMin;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewAlojamentoInfoDTO that = (NewAlojamentoInfoDTO) o;
        return alojamentoID == that.alojamentoID && tipoAlojamento == that.tipoAlojamento && local == that.local && qntdMax == that.qntdMax && qntdMin == that.qntdMin && Double.compare(that.preco, preco) == 0 && data == that.data && Objects.equals(denominacao, that.denominacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alojamentoID, denominacao, tipoAlojamento, local, qntdMax, qntdMin, preco, data);
    }
}
