package fattocs.recrutamento.listatarefas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fattocs.recrutamento.listatarefas.dtos.TarefaRequestDTO;
import fattocs.recrutamento.listatarefas.dtos.TarefaResponseDTO;
import fattocs.recrutamento.listatarefas.model.Tarefa;
import fattocs.recrutamento.listatarefas.repository.TarefaRepository;
import fattocs.recrutamento.listatarefas.utilitario.TarefaConversor;


@Service
public class TarefaServiceImpl implements TarefaService{

    @Autowired
    TarefaRepository tarefaRepository;

    @Autowired
    TarefaConversor tarefaConversor;

    @Override
    public String excluirTarefa(Long id) {
        tarefaRepository.deleteById(id);
        reOrdenar();
        return "A tarefa de id="+id+" foi excluida";
    }

    @Override
    public TarefaResponseDTO adicionarTarefa(TarefaRequestDTO tarefaRequestDTO) {
        Tarefa novaTarefa = tarefaConversor.toTarefa(tarefaRequestDTO);
        
        if(tarefaRepository.existsByNome(novaTarefa.getNome().toLowerCase())== true || novaTarefa.getNome().isEmpty() == true){
            throw new RuntimeException("Essa tarefa ja existe no repositorio ou esta vazia");
        }
        else{
            novaTarefa.setOrdem(tarefaRepository.count());
            return tarefaConversor.toResponseDTO(tarefaRepository.save(novaTarefa));
        }
    }

    @Override
    public TarefaResponseDTO editarTarefa(Long id, TarefaRequestDTO tarefaRequestDTO) {

        Tarefa tarefaAtualizada = retornaTarefa(id);

        tarefaConversor.editarTarefa(tarefaAtualizada, tarefaRequestDTO);

        
        return tarefaConversor.toResponseDTO(tarefaRepository.save(tarefaAtualizada));


    }
    

    @Override
    public List<TarefaResponseDTO> listarTarefas() {
        return tarefaConversor.toListaTarefasDTO(tarefaRepository.findAllByOrderByOrdem());
    }



    private Tarefa retornaTarefa(Long id){
        return tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("tarefa nao existe no banco de dados"));
    }

    private void reOrdenar(){
                
        for (int i = 0; i < tarefaRepository.findAll().size(); i++) {
            
            Long id = (long) i ;
            Tarefa tarefa = tarefaRepository.findAll().get(i);
            
            tarefa.setOrdem(id);
        
            tarefaRepository.save(tarefa);
    
        }
    }
    
}
