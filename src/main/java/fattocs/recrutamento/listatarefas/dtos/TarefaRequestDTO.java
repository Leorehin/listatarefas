package fattocs.recrutamento.listatarefas.dtos;

import java.math.BigDecimal;

import lombok.Getter;


@Getter
public class TarefaRequestDTO {
    String nome;
    BigDecimal custo;
    String dataLimite;
}
