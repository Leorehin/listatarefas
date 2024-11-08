package fattocs.recrutamento.listatarefas.model;

import java.math.BigDecimal;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity(name = "TAREFA")


public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "NOME")
    private String nome;

    @Column(name = "CUSTO", precision = 15, scale = 2)
    private BigDecimal custo;

    @Column(name = "DATA_LIMITE")
    private String dataLimite;

    @Column(name = "ORDEM")
    private Long ordem;

    public Tarefa() {
    }

    public Tarefa(Long id, String nome, BigDecimal custo, String dataLimite, Long ordem) {
        this.id = id;
        this.nome = nome;
        this.custo = custo;
        this.dataLimite = dataLimite;
        this.ordem = ordem;
    }
    
    public Tarefa(String nome, BigDecimal custo, String dataLimite){
        this.nome = nome;
        this.custo= custo;
        this.dataLimite = dataLimite;
    }
    
    public Tarefa(Long id, Long ordem){
        this.id = id;
        this.ordem = ordem;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public BigDecimal getCusto() {
        return custo;
    }
    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }
    public String getDataLimite() {
        return dataLimite;
    }
    public void setDataLimite(String dataLimite) {
        this.dataLimite = dataLimite;
    }
    public Long getOrdem() {
        return ordem;
    }
    public void setOrdem(Long ordem) {
        this.ordem = ordem;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((custo == null) ? 0 : custo.hashCode());
        result = prime * result + ((dataLimite == null) ? 0 : dataLimite.hashCode());
        result = prime * result + ((ordem == null) ? 0 : ordem.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tarefa other = (Tarefa) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (custo == null) {
            if (other.custo != null)
                return false;
        } else if (!custo.equals(other.custo))
            return false;
        if (dataLimite == null) {
            if (other.dataLimite != null)
                return false;
        } else if (!dataLimite.equals(other.dataLimite))
            return false;
        if (ordem == null) {
            if (other.ordem != null)
                return false;
        } else if (!ordem.equals(other.ordem))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Tarefa [id=" + id + ", nome=" + nome + ", custo=" + custo + ", dataLimite=" + dataLimite + ", ordem="
                + ordem + "]";
    }
    
}
