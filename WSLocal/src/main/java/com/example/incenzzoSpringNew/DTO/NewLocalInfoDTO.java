package com.example.incenzzoSpringNew.DTO;

import java.util.Objects;

public class NewLocalInfoDTO {
    private String pais;
    private String cidade;

    public NewLocalInfoDTO(){}

    public NewLocalInfoDTO(String pais,String cidade) {
       this.pais=pais;
       this.cidade=cidade;
    }


    public String getCidade() {
        return cidade;
    }

    public String getPais() {
        return pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewLocalInfoDTO that = (NewLocalInfoDTO) o;
        return Objects.equals(pais, that.pais) && Objects.equals(cidade, that.cidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pais, cidade);
    }
}

