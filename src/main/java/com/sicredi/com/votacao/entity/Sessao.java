package com.sicredi.com.votacao.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sessao {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;


    @OneToOne
    private Pauta pauta;


    @OneToMany(mappedBy="sessao")
    private List<Voto> votos = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }


    public Sessao() {
    }


    public Sessao(LocalDateTime dataInicio, LocalDateTime dataFim, Pauta pauta) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.pauta = pauta;
    }
}