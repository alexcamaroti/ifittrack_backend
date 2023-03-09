package br.com.cammarota.alex.ifittrack.entrypoint.http.mapper;

import br.com.cammarota.alex.ifittrack.entrypoint.http.model.AvaliacaoSaudeRequest;
import br.com.cammarota.alex.ifittrack.entrypoint.http.model.AvaliacaoSaudeResponse;
import br.com.cammarota.alex.ifittrack.usecase.model.AvaliacaoSaude;

public class AvaliacaoSaudeEntryPointMapper {

    private AvaliacaoSaudeEntryPointMapper(){
        
    }

    public static AvaliacaoSaudeResponse fromCoreToResponse(AvaliacaoSaude core) {
        return AvaliacaoSaudeResponse.builder()
                .idAvaliacao(core.getIdAvaliacao())
                .dataHora(core.getDataHora())
                .peso(core.getPeso())
                .diffPesoAnterior(core.getDiffPesoAnterior())
                .imc(core.getImc())
                .diffIMCAnterior(core.getDiffIMCAnterior())
                .gorduraCorporal(core.getGorduraCorporal())
                .diffGorduraCorporalAnterior(core.getDiffGorduraCorporalAnterior())
                .massaMuscular(core.getMassaMuscular())
                .diffMassaMuscularAnterior(core.getDiffMassaMuscularAnterior())
                .gorduraVisceral(core.getGorduraVisceral())
                .diffGorduraVisceralAnterior(core.getDiffGorduraVisceralAnterior())
                .caloriaDiaria(core.getCaloriaDiaria())
                .diffCaloriaDiariaAnterior(core.getDiffCaloriaDiariaAnterior())
                .circunferenciaAbdominal(core.getCircunferenciaAbdominal())
                .diffCircunferenciaAbdominalAnterior(core.getDiffCircunferenciaAbdominalAnterior())
                .idadeCorporal(core.getIdadeCorporal())
                .diffIdadeCorporalAnterior(core.getDiffIdadeCorporalAnterior())
                .idPerfil(core.getIdPerfil())
                .build();
    }

    public static AvaliacaoSaude fromRequestToCore(String idPerfil, AvaliacaoSaudeRequest request) {
        return AvaliacaoSaude.builder()
                .peso(request.getPeso())
                .imc(request.getImc())
                .gorduraCorporal(request.getGorduraCorporal())
                .massaMuscular(request.getMassaMuscular())
                .gorduraVisceral(request.getGorduraVisceral())
                .caloriaDiaria(request.getCaloriaDiaria())
                .circunferenciaAbdominal(request.getCircunferenciaAbdominal())
                .idadeCorporal(request.getIdadeCorporal())
                .idPerfil(idPerfil)
                .build();
    }
}
