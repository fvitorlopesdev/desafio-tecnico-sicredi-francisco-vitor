package com.sicredi.com.votacao.entity;

import com.sicredi.com.votacao.dto.PautaDto;
import jakarta.persistence.*;

@Entity
public class Pauta {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String nome;
    private String descricao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sessao_id", referencedColumnName = "id")
    private Sessao sessao;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public Pauta() {
    }

    public Pauta(String nome, String descricao, Sessao sessao) {
        this.nome = nome;
        this.descricao = descricao;
        this.sessao = sessao;
    }

    public Pauta(PautaDto pautaDto) {
        setDescricao(pautaDto.getDescricao());
        setNome(pautaDto.getNome());
    }

}