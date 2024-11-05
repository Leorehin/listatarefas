package fattocs.recrutamento.listatarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fattocs.recrutamento.listatarefas.dtos.TarefaRequestDTO;
import fattocs.recrutamento.listatarefas.dtos.TarefaResponseDTO;
import fattocs.recrutamento.listatarefas.services.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class Controller {

    @Autowired
    TarefaService listaTarefa;

    @PostMapping
    public ResponseEntity<TarefaResponseDTO> adicionarTarefa(@RequestBody TarefaRequestDTO tarefaRequestDTO){

        TarefaResponseDTO tarefaResponseDTO = listaTarefa.adicionarTarefa(tarefaRequestDTO);

        return ResponseEntity.ok().body(tarefaResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirTarefa(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(listaTarefa.excluirTarefa(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> atualizarTarefa (@RequestBody TarefaRequestDTO requestDTO, @PathVariable("id") Long id){
        return ResponseEntity.ok().body(listaTarefa.editarTarefa(id, requestDTO));
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponseDTO>> listarTarefas (){
        return ResponseEntity.ok().body(listaTarefa.listarTarefas());
    }

}
