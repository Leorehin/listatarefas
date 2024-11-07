package fattocs.recrutamento.listatarefas.dtos;

import java.math.BigDecimal;


import lombok.Getter;


@Getter
public class TarefaRequestDTO {
    private String nome;
    private BigDecimal custo;
    private String dataLimite;
}
