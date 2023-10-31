package com.sicredi.com.votacao.controller;

import com.sicredi.com.votacao.dto.ResultadoSessaoDto;
import com.sicredi.com.votacao.dto.SessaoDto;
import com.sicredi.com.votacao.entity.Pauta;
import com.sicredi.com.votacao.entity.Sessao;
import com.sicredi.com.votacao.entity.Voto;
import com.sicredi.com.votacao.service.PautaService;
import com.sicredi.com.votacao.service.SessaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class SessaoController {


    public SessaoController(SessaoService sessaoService, PautaService pautaService) {
        this.sessaoService = sessaoService;
        this.pautaService = pautaService;
    }

    private final SessaoService sessaoService;

    private final PautaService pautaService;

    static final Logger log =
            LoggerFactory.getLogger(SessaoController.class);


    @PostMapping("/abrirSessao")
    public ResponseEntity<Object> abrirSessao(@RequestBody SessaoDto sessaoDto) {

        Optional<Pauta> pauta = pautaService.getById(sessaoDto.getPautaId());

        if (sessaoDto.getDataInicio() == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Data inicio não informada");
        }
        if (pauta.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Essa pauta não existe");
        }

        if (sessaoDto.getDataFim() == null) {
            sessaoDto.setDataFim(LocalDateTime.now().plusMinutes(1));
        }
        try {
            Sessao sessao = new Sessao(sessaoDto.getDataInicio(), sessaoDto.getDataFim(), pauta.get());
            sessaoService.save(sessao);
            return new ResponseEntity<>(
                    HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao abrir sessão " + e.getMessage());

        }
    }

    @GetMapping("/sessao")
    public List<Sessao> listar() {
        return sessaoService.list();
    }


    @GetMapping("/contabilizarVotos/{sessaoId}")
    public ResponseEntity<Object> contabilizarVotos(@PathVariable(value="sessaoId") Long sessaoId) {
        ResultadoSessaoDto resultadoSessaoDto = new ResultadoSessaoDto();

        Optional<Sessao> sessao = sessaoService.getById(sessaoId);

        if (sessao.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Essa pauta não existe");
        }

        Pauta pauta = sessao.get().getPauta();

        resultadoSessaoDto.setDescricaoPauta(pauta.getDescricao());
        resultadoSessaoDto.setNomePauta(pauta.getNome());


        Integer votosPositivos = Math.toIntExact(sessao.get().getVotos().stream().filter(Voto::getVoto).count());
        Integer votosNegativos = Math.toIntExact(sessao.get().getVotos().stream().filter(voto -> !voto.getVoto()).count());

        resultadoSessaoDto.setVotosNegativos(votosNegativos);
        resultadoSessaoDto.setVotosPositivos(votosPositivos);

        return new ResponseEntity<>(
                resultadoSessaoDto
                , HttpStatus.OK);

    }

}