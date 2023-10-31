package com.sicredi.com.votacao.entity;

import com.sicredi.com.votacao.dto.VotoDto;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Voto {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private Boolean voto;


    @OneToOne
    private Associado associado;

    private LocalDateTime dataHoraVoto;

    @ManyToOne
    @JoinColumn(name = "sessao_id", referencedColumnName = "id")
    private Sessao sessao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getVoto() {
        return voto;
    }

    public void setVoto(Boolean voto) {
        this.voto = voto;
    }

    public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }

    public LocalDateTime getDataHoraVoto() {
        return dataHoraVoto;
    }

    public void setDataHoraVoto(LocalDateTime dataHoraVoto) {
        this.dataHoraVoto = dataHoraVoto;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }


    public Voto(Boolean voto, Associado associado, LocalDateTime dataHoraVoto, Sessao sessao) {
        this.voto = voto;
        this.associado = associado;
        this.dataHoraVoto = dataHoraVoto;
        this.sessao = sessao;
    }



    public Voto(VotoDto votoDto, Associado associado, Sessao sessao) {
        setVoto(votoDto.getVoto());
        setAssociado(associado);
        setSessao(sessao);
    }
}