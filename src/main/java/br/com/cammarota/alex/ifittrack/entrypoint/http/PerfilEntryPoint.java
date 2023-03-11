package br.com.cammarota.alex.ifittrack.entrypoint.http;


import br.com.cammarota.alex.ifittrack.entrypoint.http.mapper.PerfilEntryPointMapper;
import br.com.cammarota.alex.ifittrack.entrypoint.http.model.PerfilRequest;
import br.com.cammarota.alex.ifittrack.entrypoint.http.model.PerfilResponse;
import br.com.cammarota.alex.ifittrack.usecase.CadastroPerfilUseCase;
import br.com.cammarota.alex.ifittrack.usecase.ConsultaPerfisUseCase;
import br.com.cammarota.alex.ifittrack.usecase.model.Perfil;
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
public class PerfilEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(PerfilEntryPoint.class.getName());

    @Autowired
    private CadastroPerfilUseCase cadastroPerfilUseCase;
    @Autowired
    private ConsultaPerfisUseCase consultaPerfilUseCase;

    @GetMapping
    public ResponseEntity<List<PerfilResponse>> getPerfis() throws Exception {
        List<PerfilResponse> perfis = new ArrayList<>();
        for (Perfil perfil : consultaPerfilUseCase.getPerfis()) {
            PerfilResponse perfilResponse = PerfilEntryPointMapper.fromCoreToResponse(perfil);
            perfis.add(perfilResponse);
        }
        return ResponseEntity.ok(perfis);
    }


    @PostMapping
    public ResponseEntity<PerfilResponse> salvar(@RequestBody @Valid PerfilRequest request) throws Exception {
            Perfil core = PerfilEntryPointMapper.fromRequestToCore(request);
            Perfil perfilSalvo = cadastroPerfilUseCase.salvar(core);
            PerfilResponse response = PerfilEntryPointMapper.fromCoreToResponse(perfilSalvo);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
