package com.revendas.mobiauto.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Schema(description = "Modelo que representando um usuário no sistema")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do usuário", example = "1", required = true)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    @Schema(description = "Email do usuário", example = "usuario@example.com", required = true)
    private String email;

    @Schema(description = "Senha do usuário", required = true)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Cargo do usuário", example = "Gerente", required = true)
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "revenda_id")
    @Schema(description = "Revenda associada ao usuário", required = true)
    private Revenda revenda;

    @OneToMany(mappedBy = "responsavel")
    @Schema(description = "Lista de oportunidades associadas ao usuário")
    private List<Oportunidade> oportunidades;

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

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Revenda getRevenda() {
        return revenda;
    }

    public void setRevenda(Revenda revenda) {
        this.revenda = revenda;
    }

    public List<Oportunidade> getOportunidades() {
        return oportunidades;
    }

    public void setOportunidades(List<Oportunidade> oportunidades) {
        this.oportunidades = oportunidades;
    }
}
