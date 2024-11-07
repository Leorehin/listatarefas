package fattocs.recrutamento.listatarefas.dtos;


import java.math.BigDecimal;


import fattocs.recrutamento.listatarefas.model.Tarefa;
import lombok.Getter;



@Getter

public class TarefaResponseDTO {
    private Long id;
    private String nome;
    private BigDecimal custo;
    private String dataLimite;
    private Long ordem;


    public TarefaResponseDTO(Tarefa tarefa){
        this.id = tarefa.getId();
        this.nome = tarefa.getNome();
        this.custo= tarefa.getCusto();
        this.dataLimite = tarefa.getDataLimite();
        this.ordem = tarefa.getOrdem();
    }
}
