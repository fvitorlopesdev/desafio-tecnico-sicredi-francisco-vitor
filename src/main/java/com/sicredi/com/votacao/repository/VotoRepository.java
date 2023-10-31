package com.sicredi.com.votacao.repository;

import com.sicredi.com.votacao.entity.Associado;
import com.sicredi.com.votacao.entity.Sessao;
import com.sicredi.com.votacao.entity.Voto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends CrudRepository<Voto, Long> {

    public Boolean existsVotoByAssociadoAndSessao(Associado associado, Sessao sessao);


}