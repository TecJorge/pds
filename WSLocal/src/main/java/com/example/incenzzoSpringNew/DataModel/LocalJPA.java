package com.example.incenzzoSpringNew.DataModel;

import lombok.Getter;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Table(name="Local")
public class LocalJPA {
        @Id
        @PrimaryKeyJoinColumn
        @Getter
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="idLocal")
        private int localID;
        @Getter
        private String pais;
        @Getter
        private String cidade;

        public LocalJPA() {
        }
        public LocalJPA(String pais,String cidade) {
                this.pais=pais;
                this.cidade=cidade;
        }

}
