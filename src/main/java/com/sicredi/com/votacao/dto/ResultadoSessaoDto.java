package com.sicredi.com.votacao.dto;

public class ResultadoSessaoDto {

    private Integer  votosPositivos;

    private Integer votosNegativos;

    private String nomePauta;

    private String descricaoPauta;


    public Integer getVotosPositivos() {
        return votosPositivos;
    }

    public void setVotosPositivos(Integer votosPositivos) {
        this.votosPositivos = votosPositivos;
    }

    public Integer getVotosNegativos() {
        return votosNegativos;
    }

    public void setVotosNegativos(Integer votosNegativos) {
        this.votosNegativos = votosNegativos;
    }

    public String getNomePauta() {
        return nomePauta;
    }

    public void setNomePauta(String nomePauta) {
        this.nomePauta = nomePauta;
    }

    public String getDescricaoPauta() {
        return descricaoPauta;
    }

    public void setDescricaoPauta(String descricaoPauta) {
        this.descricaoPauta = descricaoPauta;
    }
}
