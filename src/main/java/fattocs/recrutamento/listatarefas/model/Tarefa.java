package fattocs.recrutamento.listatarefas.model;

import java.math.BigDecimal;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity(name = "TAREFA")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter

public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;
    
    @Column(name = "NOME")
    String nome;

    @Column(name = "CUSTO", precision = 15, scale = 2)
    BigDecimal custo;

    @Column(name = "DATA_LIMITE")
    String dataLimite;

    @Column(name = "ORDEM")
    Long ordem;

    @Builder
    public Tarefa(String nome, BigDecimal custo, String dataLimite){
        this.nome = nome;
        this.custo= custo;
        this.dataLimite = dataLimite;
    }
    @Builder
    public Tarefa(Long id, Long ordem){
        this.id = id;
        this.ordem = ordem;
    }
    
}
