package com.revendas.mobiauto.dto;

public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private Long revendaId; // ID da revenda a qual o usuário está associado
    private String cargo;

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getRevendaId() {
        return revendaId;
    }

    public void setRevendaId(Long revendaId) {
        this.revendaId = revendaId;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}