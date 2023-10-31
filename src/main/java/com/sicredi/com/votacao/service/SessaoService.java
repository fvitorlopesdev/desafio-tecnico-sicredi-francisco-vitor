package com.sicredi.com.votacao.service;

import com.sicredi.com.votacao.entity.Associado;
import com.sicredi.com.votacao.entity.Pauta;
import com.sicredi.com.votacao.entity.Sessao;
import com.sicredi.com.votacao.repository.PautaRepository;
import com.sicredi.com.votacao.repository.SessaoRepository;
import com.sicredi.com.votacao.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SessaoService {

    @Autowired
    SessaoRepository sessaoRepository;

    @Autowired
    VotoRepository votoRepository;


    public void save(Sessao sessao){
        sessaoRepository.save(sessao);
    }

    public List<Sessao> list(){
        List<Sessao> result = new ArrayList<>();
        sessaoRepository.findAll().forEach(result::add);
        return result;
    }



    public Optional<Sessao> getById(Long id){
        return sessaoRepository.findById(id);
    }



}
