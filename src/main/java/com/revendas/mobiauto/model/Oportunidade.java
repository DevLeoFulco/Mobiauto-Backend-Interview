package com.revendas.mobiauto.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Schema(description = "Modelo que representa uma oportunidade no sistema de revendas")
public class Oportunidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID da oportunidade", example = "1", required = true)
    private Long id;

    @Schema(description = "Nome do cliente", example = "Cliente Exemplo", required = true)
    private String nomeCliente;

    @Schema(description = "Email do cliente", example = "cliente@examplo.com", required = true)
    private String emailCliente;

    @Schema(description = "Telefone do cliente", example = "(11) 98765-4321", required = true)
    private String telefoneCliente;

    @Schema(description = "Marca do veículo que tem interesse", example = "Honda", required = true)
    private String marcaVeiculo;

    @Schema(description = "Modelo do veículo que tem interesse", example = "HRV", required = true)
    private String modeloVeiculo;

    @Schema(description = "Versão do veículo que tem interesse", example = "2.0 LTS", required = true)
    private String versaoVeiculo;

    @Schema(description = "Ano do modelo do veículo que tem interesse", example = "2023", required = true)
    private Integer anoModelo;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Status da oportunidade", example = "NOVO", required = true)
    private StatusOportunidade status = StatusOportunidade.NOVO;

    @Schema(description = "Motivo de conclusão da oportunidade")
    private String motivoConclusao;
    private LocalDateTime dataAtribuicao;
    private LocalDateTime dataConclusao;

    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    @Schema(description = "Usuário responsável pela oportunidade", required = true)
    private Usuario responsavel;

    @ManyToOne
    @JoinColumn(name = "revenda_id")
    @Schema(description = "Revenda associada à oportunidade", required = true)
    private Revenda revenda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getVersaoVeiculo() {
        return versaoVeiculo;
    }

    public void setVersaoVeiculo(String versaoVeiculo) {
        this.versaoVeiculo = versaoVeiculo;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public StatusOportunidade getStatus() {
        return status;
    }

    public void setStatus(StatusOportunidade status) {
        this.status = status;
    }

    public String getMotivoConclusao() {
        return motivoConclusao;
    }

    public void setMotivoConclusao(String motivoConclusao) {
        this.motivoConclusao = motivoConclusao;
    }

    public LocalDateTime getDataAtribuicao() {
        return dataAtribuicao;
    }

    public void setDataAtribuicao(LocalDateTime dataAtribuicao) {
        this.dataAtribuicao = dataAtribuicao;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public Revenda getRevenda() {
        return revenda;
    }

    public void setRevenda(Revenda revenda) {
        this.revenda = revenda;
    }
}
