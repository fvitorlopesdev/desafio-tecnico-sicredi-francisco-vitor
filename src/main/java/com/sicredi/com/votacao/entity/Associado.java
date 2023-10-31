package com.sicredi.com.votacao.entity;

import com.sicredi.com.votacao.dto.AssociadoDto;
import jakarta.persistence.*;

@Entity
public class Associado {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String nome;

    private String cpf;


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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public Associado(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Associado() {
    }

    public Associado(AssociadoDto associadoDto) {
        setNome(associadoDto.getNome());
        setCpf(associadoDto.getCpf());
    }

}