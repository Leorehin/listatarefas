package fattocs.recrutamento.listatarefas.dtos;

import java.math.BigDecimal;

import fattocs.recrutamento.listatarefas.model.Tarefa;
import lombok.Getter;



@Getter

public class TarefaResponseDTO {
    Long id;
    String nome;
    BigDecimal custo;
    String dataLimite;
    Long ordem;


    public TarefaResponseDTO(Tarefa tarefa){
        this.id = tarefa.getId();
        this.nome = tarefa.getNome();
        this.custo= tarefa.getCusto();
        this.dataLimite = tarefa.getDataLimite();
        this.ordem = tarefa.getOrdem();
    }
}
