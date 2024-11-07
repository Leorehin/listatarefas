package fattocs.recrutamento.listatarefas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fattocs.recrutamento.listatarefas.dtos.TarefaOrdemDTO;
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
        
        if(tarefaRepository.existsByNome(novaTarefa.getNome().toLowerCase())== true){
            throw new RuntimeException("Essa tarefa ja existe no repositorio");
        }
        else if(novaTarefa.getNome().isEmpty() || novaTarefa.getDataLimite().isEmpty()){
            throw new RuntimeException("Nenhum campo pode ser nulo");
        }
        else{
            novaTarefa.setOrdem(tarefaRepository.count());
            return tarefaConversor.toResponseDTO(tarefaRepository.save(novaTarefa));
        }
    }

    public TarefaResponseDTO editarTarefa(Long id, TarefaRequestDTO tarefaRequestDTO) {

        // Obtém a tarefa que será atualizada
        Tarefa tarefaAtualizada = retornaTarefa(id);
    
        // Verifica se o novo nome já existe em outra tarefa
        if (!tarefaAtualizada.getNome().equals(tarefaRequestDTO.getNome())) {
            boolean nomeExistente = tarefaRepository.existsByNome(tarefaRequestDTO.getNome());
            if (nomeExistente) {
                throw new IllegalArgumentException("O nome da tarefa já existe. Alteração não permitida.");
            }
        }
    
        // Atualiza apenas os campos permitidos
        tarefaConversor.editarTarefa(tarefaAtualizada, tarefaRequestDTO);
    
        // Salva a tarefa atualizada no banco e retorna o DTO de resposta
        return tarefaConversor.toResponseDTO(tarefaRepository.save(tarefaAtualizada));
    }
    

    @Override
    public List<TarefaResponseDTO> listarTarefas() {
        return tarefaConversor.toListaTarefasDTO(tarefaRepository.findAllByOrderByOrdem());
    }

    private Tarefa retornaTarefa(Long id){
        return tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("tarefa nao existe no banco de dados"));
    }

    @Override
    public String reordenarTarefas(List<TarefaOrdemDTO> novaOrdem) {
        List<Tarefa> tarefaSemOrdem = tarefaRepository.findAll();
        tarefaSemOrdem.forEach(o -> o.setOrdem(null));
        tarefaRepository.saveAll(tarefaSemOrdem);
        
        for (int i = 0; i < novaOrdem.size(); i++) {
            Long ordem = (long) i;
            Optional<Tarefa> optionalTarefa = tarefaRepository.findById(novaOrdem.get(i).getId());
            optionalTarefa.get().setOrdem(ordem); // Define nova ordem
            tarefaRepository.save(optionalTarefa.get());
        }

        


        return "Tarefas Reordenadas";
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
