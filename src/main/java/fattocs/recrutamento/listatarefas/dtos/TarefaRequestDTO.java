package fattocs.recrutamento.listatarefas.dtos;

import java.math.BigDecimal;


import lombok.Getter;



public class TarefaRequestDTO {
    private String nome;
    private BigDecimal custo;
    private String dataLimite;
    
    
    public TarefaRequestDTO(String nome, BigDecimal custo, String dataLimite) {
        this.nome = nome;
        this.custo = custo;
        this.dataLimite = dataLimite;
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
}
