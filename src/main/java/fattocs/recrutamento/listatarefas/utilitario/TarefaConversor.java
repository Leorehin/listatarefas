package fattocs.recrutamento.listatarefas.utilitario;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import fattocs.recrutamento.listatarefas.dtos.TarefaOrdemDTO;
import fattocs.recrutamento.listatarefas.dtos.TarefaRequestDTO;
import fattocs.recrutamento.listatarefas.dtos.TarefaResponseDTO;
import fattocs.recrutamento.listatarefas.model.Tarefa;

@Component
public class TarefaConversor {

    public Tarefa toTarefa ( TarefaRequestDTO tarefaRequestDTO) {
        return new Tarefa(tarefaRequestDTO.getNome().toLowerCase(), tarefaRequestDTO.getCusto(), tarefaRequestDTO.getDataLimite());   
    }
    public Tarefa toTarefa( TarefaOrdemDTO tarefaOrdemDTO){
        return new Tarefa(tarefaOrdemDTO.getId(), tarefaOrdemDTO.getOrdem());
    }

    public TarefaResponseDTO toResponseDTO(Tarefa tarefa){
        return new TarefaResponseDTO(tarefa);
    }

    public List<TarefaResponseDTO> toListaTarefasDTO(List<Tarefa> tarefas){
        return tarefas.stream().map(TarefaResponseDTO::new).collect(Collectors.toList());
    }

    public void editarTarefa(Tarefa tarefa, TarefaRequestDTO tarefaDTO){
        if(tarefaDTO.getNome() != null){
        tarefa.setNome(tarefaDTO.getNome());
        }
        if(tarefaDTO.getCusto() != null){
        tarefa.setCusto(tarefaDTO.getCusto());
        }
        if(tarefaDTO.getDataLimite() != null){
        tarefa.setDataLimite(tarefaDTO.getDataLimite());
        }
    }
    

}
