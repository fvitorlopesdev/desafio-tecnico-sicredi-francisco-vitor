package com.sicredi.com.votacao.controller;

import com.sicredi.com.votacao.dto.VotoDto;
import com.sicredi.com.votacao.entity.Associado;
import com.sicredi.com.votacao.entity.Sessao;
import com.sicredi.com.votacao.entity.Voto;
import com.sicredi.com.votacao.service.AssociadoService;
import com.sicredi.com.votacao.service.SessaoService;
import com.sicredi.com.votacao.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class VotoController {

    private final VotoService votoService;

    private final SessaoService sessaoService;

    private final AssociadoService associadoService;


    public VotoController(VotoService votoService, SessaoService sessaoService, AssociadoService associadoService) {
        this.votoService = votoService;
        this.sessaoService = sessaoService;
        this.associadoService = associadoService;
    }


    @PostMapping("/votar")
    public ResponseEntity<Object> votar (@RequestBody VotoDto votoDto) {

        Optional<Associado> associado = associadoService.getById(votoDto.getAssociadoid());

        if (associado.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Esse associado não existe");
        }

        Optional<Sessao> sessao = sessaoService.getById(votoDto.getSessaoId());

        if (sessao.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Essa sessao não existe");
        }


        Voto voto = new Voto(votoDto,associado.get(),sessao.get());
        if(votoService.associadoJaVotou(voto)){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Esse associado já votou nessa sessão");
        }

        if(votoDto.getVoto() == null){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Voto não valido");
        }


        if(sessao.get().getDataFim().isAfter(LocalDateTime.now())){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Não foi possível votar, sessão já encerrada");
        }


        try {
            votoService.save(voto);
            return new ResponseEntity<>(
                    HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar voto " + e.getMessage());
        }
    }

    @GetMapping("/voto")
    public List<Voto> list () {
        return votoService.list();
    }

}