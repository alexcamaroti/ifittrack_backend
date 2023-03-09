package br.com.cammarota.alex.ifittrack.entrypoint.http;

import br.com.cammarota.alex.ifittrack.config.exception.AvaliacaoNotFoundException;
import br.com.cammarota.alex.ifittrack.config.exception.CadastroAvaliacaoSaudeException;
import br.com.cammarota.alex.ifittrack.config.exception.InvalidPerfilException;
import br.com.cammarota.alex.ifittrack.entrypoint.http.mapper.AvaliacaoSaudeEntryPointMapper;
import br.com.cammarota.alex.ifittrack.entrypoint.http.model.AvaliacaoSaudeRequest;
import br.com.cammarota.alex.ifittrack.entrypoint.http.model.AvaliacaoSaudeResponse;
import br.com.cammarota.alex.ifittrack.usecase.CadastroAvaliacaoSaudeUseCase;
import br.com.cammarota.alex.ifittrack.usecase.ConsultaAvaliacoesSaudeUseCase;
import br.com.cammarota.alex.ifittrack.usecase.model.AvaliacaoSaude;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("profiles")
public class AvaliacaoSaudeEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(AvaliacaoSaudeEntryPoint.class.getName());

    @Autowired
    private CadastroAvaliacaoSaudeUseCase cadastroAvaliacaoSaudeUseCase;

    @Autowired
    private ConsultaAvaliacoesSaudeUseCase consultaAvaliacaoSaudeUseCase;


    @GetMapping("{idPerfil}/avaliacoes")
    public ResponseEntity<List<AvaliacaoSaudeResponse>> consultarAvaliacoes(@PathVariable String idPerfil) throws AvaliacaoNotFoundException {
        List<AvaliacaoSaudeResponse> avaliacoes = new ArrayList<>();
        for (AvaliacaoSaude avaliacao : consultaAvaliacaoSaudeUseCase.getAvaliacoesPorIdPerfil(idPerfil)) {
            AvaliacaoSaudeResponse avaliacaoSaudeResponse = AvaliacaoSaudeEntryPointMapper.fromCoreToResponse(avaliacao);
            avaliacoes.add(avaliacaoSaudeResponse);
        }
        return ResponseEntity.ok(avaliacoes);
    }

    @PostMapping("{idPerfil}/avaliacoes")
    public ResponseEntity<AvaliacaoSaudeResponse> cadastrar(@PathVariable String idPerfil,
                                                            @RequestBody @Valid AvaliacaoSaudeRequest request) throws CadastroAvaliacaoSaudeException, InvalidPerfilException {
        AvaliacaoSaude core = AvaliacaoSaudeEntryPointMapper.fromRequestToCore(idPerfil, request);
        AvaliacaoSaude avaliacaoSalva = cadastroAvaliacaoSaudeUseCase.cadastrar(core);
        AvaliacaoSaudeResponse response = AvaliacaoSaudeEntryPointMapper.fromCoreToResponse(avaliacaoSalva);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
