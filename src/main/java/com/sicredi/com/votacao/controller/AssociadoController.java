package com.sicredi.com.votacao.controller;

import com.sicredi.com.votacao.dto.AssociadoDto;
import com.sicredi.com.votacao.entity.Associado;
import com.sicredi.com.votacao.service.AssociadoService;
import com.sicredi.com.votacao.validacao.ValidadorCPF;
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
public class AssociadoController {

    private final AssociadoService associadoService;

    private final ValidadorCPF validadorCPF;

    public AssociadoController(AssociadoService associadoService, ValidadorCPF validadorCPF) {
        this.associadoService = associadoService;
        this.validadorCPF = validadorCPF;
    }

    static final Logger log =
            LoggerFactory.getLogger(AssociadoController.class);

    @PostMapping("/associado")
    public ResponseEntity<Object> salvarAssociado(@RequestBody AssociadoDto associadoDto) {
        Associado associado = new Associado(associadoDto);

        if (!validadorCPF.isCPF(associadoDto.getCpf())) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Formato de cpf não válido");
        }
        if (associadoDto.getNome() == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Nome não informado");
        }
        try {
            associadoService.save(associado);
            return new ResponseEntity<>(
                    HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar associado " + e.getMessage());

        }
    }

    @GetMapping("/associado")
    public List<Associado> listar() {
        return associadoService.list();
    }

}
