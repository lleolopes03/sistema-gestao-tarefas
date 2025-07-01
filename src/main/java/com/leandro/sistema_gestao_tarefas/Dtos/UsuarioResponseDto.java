package com.leandro.sistema_gestao_tarefas.Dtos;

import com.leandro.sistema_gestao_tarefas.model.Endereco;

import java.time.LocalDate;

public class UsuarioResponseDto {
    private Long id;
    private String nome;
    private String email;
    private Integer idade;
    private String telefone;
    private Endereco endereco;
    private LocalDate dataNascimento;


    public UsuarioResponseDto() {
    }

    public UsuarioResponseDto(Long id, String nome, String email, Integer idade, String telefone, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.telefone = telefone;
        this.endereco = endereco;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "UsuarioResponseDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                ", telefone='" + telefone + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
