package com.sicredi.com.votacao.service;

import com.sicredi.com.votacao.entity.Associado;
import com.sicredi.com.votacao.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssociadoService {

    @Autowired
    AssociadoRepository associadoRepository;

    public void save(Associado associado){
        associadoRepository.save(associado);
    }

    public Optional<Associado> getById(Long associadoId){
        return associadoRepository.findById(associadoId);
    }

    public List<Associado> list(){
        List<Associado> result = new ArrayList<>();
        associadoRepository.findAll().forEach(result::add);
        return result;
    }

}
