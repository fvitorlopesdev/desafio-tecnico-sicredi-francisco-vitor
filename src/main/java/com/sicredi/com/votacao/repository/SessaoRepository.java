package com.sicredi.com.votacao.repository;

import com.sicredi.com.votacao.entity.Sessao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoRepository extends CrudRepository<Sessao, Long> {


}