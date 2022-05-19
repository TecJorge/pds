package com.example.incenzzoSpringNew.Domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
@ToString
@EqualsAndHashCode
public class Local {
        @Getter
        private String pais;
        @Getter
        private String cidade;
        public Local(String pais,String cidade){
            this.pais=pais;
            this.cidade=cidade;
        }
        public Local(){
        }
}
