package com.sicredi.com.votacao.dto;

public class VotoDto {

    private Boolean voto;

    private Long associadoid;

    private Long sessaoId;

    public Long getAssociadoid() {
        return associadoid;
    }

    public void setAssociadoid(Long associadoid) {
        this.associadoid = associadoid;
    }

    public Long getSessaoId() {
        return sessaoId;
    }

    public void setSessaoId(Long sessaoId) {
        this.sessaoId = sessaoId;
    }

    public Boolean getVoto() {
        return voto;
    }

    public void setVoto(Boolean voto) {
        this.voto = voto;
    }
}