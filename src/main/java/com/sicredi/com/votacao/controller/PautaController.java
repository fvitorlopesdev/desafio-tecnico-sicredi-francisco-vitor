package com.sicredi.com.votacao.controller;

import com.sicredi.com.votacao.dto.PautaDto;
import com.sicredi.com.votacao.entity.Pauta;
import com.sicredi.com.votacao.service.PautaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PautaController {

    private final PautaService pautaService;

    static final Logger log =
            LoggerFactory.getLogger(PautaController.class);

    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @PostMapping("/pauta")
    public ResponseEntity<Object> salvarPauta(@RequestBody PautaDto pautaDto) {

        if (pautaDto.getNome() == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Nome não informado");
        }
        if (pautaDto.getDescricao() == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Nome não informada");
        }

        try {
            Pauta pauta = new Pauta(pautaDto);
            pautaService.save(pauta);
            return new ResponseEntity<>(
                    HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar pauta " + e.getMessage());

        }
    }

    @GetMapping("/pauta")
    public List<Pauta> listar() {
        return pautaService.list();
    }

}