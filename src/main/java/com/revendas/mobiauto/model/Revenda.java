package com.revendas.mobiauto.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Schema(description = "Modelo que representa uma revenda no sistema")
public class Revenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID da revenda", example = "1", required = true)
    private Long id;

    @Column(unique = true, nullable = false)
    @Schema(description = "CNPJ da revenda", example = "12.345.678/0001-99", required = true)
    private String cnpj;

    @Schema(description = "Nome social da revenda", example = "Revenda Mobi Recife Centro", required = true)
    private String nomeSocial;

    @OneToMany(mappedBy = "revenda")
    @Schema(description = "Lista de usuários associados à revenda")
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "revenda")
    @Schema(description = "Lista de revendas associados ao usuário")
    private List<Oportunidade> oportunidades;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Oportunidade> getOportunidades() {
        return oportunidades;
    }

    public void setOportunidades(List<Oportunidade> oportunidades) {
        this.oportunidades = oportunidades;
    }
}