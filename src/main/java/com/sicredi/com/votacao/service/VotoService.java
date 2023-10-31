package com.sicredi.com.votacao.service;

import com.sicredi.com.votacao.entity.Associado;
import com.sicredi.com.votacao.entity.Sessao;
import com.sicredi.com.votacao.entity.Voto;
import com.sicredi.com.votacao.repository.SessaoRepository;
import com.sicredi.com.votacao.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VotoService {

    @Autowired
    VotoRepository votoRepository;

    public void save(Voto voto){
        voto.setDataHoraVoto(LocalDateTime.now());
        votoRepository.save(voto);
    }

    public boolean associadoJaVotou(Voto voto){
        return  votoRepository.existsVotoByAssociadoAndSessao(voto.getAssociado(), voto.getSessao());
    }


    public List<Voto> list(){
        List<Voto> result = new ArrayList<>();
        votoRepository.findAll().forEach(result::add);
        return result;
    }

}