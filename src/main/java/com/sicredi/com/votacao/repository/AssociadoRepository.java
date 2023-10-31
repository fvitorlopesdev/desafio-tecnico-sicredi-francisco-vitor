package com.sicredi.com.votacao.repository;

import com.sicredi.com.votacao.entity.Associado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociadoRepository extends CrudRepository<Associado, Long> {
}