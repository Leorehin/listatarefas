package fattocs.recrutamento.listatarefas.dtos;


import java.math.BigDecimal;


import fattocs.recrutamento.listatarefas.model.Tarefa;
import lombok.Getter;





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


    public Long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }


    public BigDecimal getCusto() {
        return custo;
    }


    public String getDataLimite() {
        return dataLimite;
    }


    public Long getOrdem() {
        return ordem;
    }
}
