package fattocs.recrutamento.listatarefas.services;

import java.util.List;


import fattocs.recrutamento.listatarefas.dtos.TarefaOrdemDTO;
import fattocs.recrutamento.listatarefas.dtos.TarefaRequestDTO;
import fattocs.recrutamento.listatarefas.dtos.TarefaResponseDTO;


public interface TarefaService {

    String excluirTarefa(Long id);


    TarefaResponseDTO adicionarTarefa(TarefaRequestDTO tarefaRequestDTO);

    TarefaResponseDTO editarTarefa(Long id, TarefaRequestDTO tarefaRequestDTO);

    List<TarefaResponseDTO> listarTarefas();

    String reordenarTarefas(List<TarefaOrdemDTO> novaOrdem);
    
}
