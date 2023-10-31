package com.sicredi.com.votacao.repository;

import com.sicredi.com.votacao.entity.Pauta;
import com.sicredi.com.votacao.entity.Voto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository extends CrudRepository<Pauta, Long> {
}