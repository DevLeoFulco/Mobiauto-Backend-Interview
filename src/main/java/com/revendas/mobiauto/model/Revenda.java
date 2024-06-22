package com.revendas.mobiauto.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Revenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String cnpj;

    private String nomeSocial;

    @OneToMany(mappedBy = "revenda")
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "revenda")
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