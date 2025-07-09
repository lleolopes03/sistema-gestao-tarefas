package com.leandro.sistema_gestao_tarefas.model;

import com.leandro.sistema_gestao_tarefas.model.Enums.Prioridade;
import com.leandro.sistema_gestao_tarefas.model.Enums.StatusTarefa;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_tarefa")
public class Tarefa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private LocalDateTime prazo;
    @Enumerated(EnumType.STRING)
    private StatusTarefa status;
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;
    private String categoria;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private LocalDateTime dataConclusao;
    private String observacoes;

    public Tarefa() {
    }

    public Tarefa(Long id, String nome, String descricao, LocalDateTime dataCriacao, LocalDateTime prazo, StatusTarefa status, Prioridade prioridade, String categoria, Usuario usuario, LocalDateTime dataConclusao, String observacoes) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.prazo = prazo;
        this.status = status;
        this.prioridade = prioridade;
        this.categoria = categoria;
        this.usuario = usuario;
        this.dataConclusao = dataConclusao;
        this.observacoes = observacoes;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDateTime prazo) {
        this.prazo = prazo;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tarefa tarefas)) return false;
        return Objects.equals(id, tarefas.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
