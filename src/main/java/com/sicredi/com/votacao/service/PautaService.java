package com.sicredi.com.votacao.service;

import com.sicredi.com.votacao.entity.Associado;
import com.sicredi.com.votacao.entity.Pauta;
import com.sicredi.com.votacao.repository.AssociadoRepository;
import com.sicredi.com.votacao.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PautaService {

    @Autowired
    PautaRepository pautaRepository;

    public void save(Pauta pauta){
        pautaRepository.save(pauta);
    }

    public List<Pauta> list(){
        List<Pauta> result = new ArrayList<>();
        pautaRepository.findAll().forEach(result::add);
        return result;
    }


    public Optional<Pauta> getById(Long id){
        return pautaRepository.findById(id);
    }

}
