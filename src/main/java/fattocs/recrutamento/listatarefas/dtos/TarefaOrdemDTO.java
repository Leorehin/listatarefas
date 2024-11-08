package fattocs.recrutamento.listatarefas.dtos;

import lombok.Getter;

public class TarefaOrdemDTO {
    private Long id;
    private Long ordem;
    
    
    public TarefaOrdemDTO(Long id, Long ordem) {
        this.id = id;
        this.ordem = ordem;
    }
    public Long getId() {
        return id;
    }
    public Long getOrdem() {
        return ordem;
    }
}
