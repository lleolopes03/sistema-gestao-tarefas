package com.leandro.sistema_gestao_tarefas.Dtos;

import com.leandro.sistema_gestao_tarefas.model.Endereco;
import com.leandro.sistema_gestao_tarefas.model.Usuario;

import java.time.LocalDate;

public class UsuarioResponseDto {
    private Long id;
    private String nome;
    private String email;
    private Integer idade;
    private String telefone;
    private Endereco endereco;
    private LocalDate dataNascimento;
    private String username;
    private Usuario.Role role = Usuario.Role.USUARIO;




    public UsuarioResponseDto() {
    }

    public UsuarioResponseDto(Long id, String nome, String email, Integer idade, String telefone, LocalDate dataNascimento, Endereco endereco, String username, Usuario.Role role) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.username = username;
        this.role = role;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Usuario.Role getRole() {
        return role;
    }

    public void setRole(Usuario.Role role) {
        this.role = role;
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
                ", dataNascimento=" + dataNascimento +
                ", username='" + username + '\'' +
                ", role=" + role +
                '}';
    }
}
