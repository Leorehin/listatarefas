package fattocs.recrutamento.listatarefas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import fattocs.recrutamento.listatarefas.model.Tarefa;

@EnableJpaRepositories
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    boolean existsByNome(String nome);

    Tarefa findByNome(String nome);

    List<Tarefa> findAllByOrderByOrdem();

}
