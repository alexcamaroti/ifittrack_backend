package br.com.cammarota.alex.ifittrack.dataprovider.db.mapper;

import br.com.cammarota.alex.ifittrack.dataprovider.db.repository.entity.AvaliacaoSaudeEntity;
import br.com.cammarota.alex.ifittrack.usecase.model.AvaliacaoSaude;

public class AvaliacaoSaudeDataProviderMapper {

    private AvaliacaoSaudeDataProviderMapper(){
    }

    public static AvaliacaoSaudeEntity fromCoreToEntity(AvaliacaoSaude core) {
        
        return AvaliacaoSaudeEntity.builder()
                .idAvaliacao(core.getIdAvaliacao())
                .dataHora(core.getDataHora())
                .peso(core.getPeso())
                .diffPesoAnterior(core.getDiffPesoAnterior())
                .imc(core.getImc())
                .diffIMCAnterior(core.getDiffIMCAnterior())
                .gorduraCorporal(core.getGorduraCorporal())
                .diffGorduraCorporalAnterior(core.getDiffGorduraCorporalAnterior())
                .gorduraVisceral(core.getGorduraVisceral())
                .diffGorduraVisceralAnterior(core.getDiffGorduraVisceralAnterior())
                .caloriaDiaria(core.getCaloriaDiaria())
                .diffCaloriaDiariaAnterior(core.getDiffCaloriaDiariaAnterior())
                .circunferenciaAbdominal(core.getCircunferenciaAbdominal())
                .diffCircunferenciaAbdominalAnterior(core.getDiffCircunferenciaAbdominalAnterior())
                .idadeCorporal(core.getIdadeCorporal())
                .diffIdadeCorporalAnterior(core.getDiffIdadeCorporalAnterior())
                .massaMuscular(core.getMassaMuscular())
                .diffMassaMuscularAnterior(core.getDiffMassaMuscularAnterior())
                .idPerfil(core.getIdPerfil())
                .build();
    }

    public static AvaliacaoSaude fromEntityToCore(AvaliacaoSaudeEntity entity) {

        return AvaliacaoSaude.builder()
                .idAvaliacao(entity.getIdAvaliacao())
                .dataHora(entity.getDataHora())
                .peso(entity.getPeso())
                .diffPesoAnterior(entity.getDiffPesoAnterior())
                .imc(entity.getImc())
                .diffIMCAnterior(entity.getDiffIMCAnterior())
                .gorduraCorporal(entity.getGorduraCorporal())
                .diffGorduraCorporalAnterior(entity.getDiffGorduraCorporalAnterior())
                .gorduraVisceral(entity.getGorduraVisceral())
                .diffGorduraVisceralAnterior(entity.getDiffGorduraVisceralAnterior())
                .caloriaDiaria(entity.getCaloriaDiaria())
                .diffCaloriaDiariaAnterior(entity.getDiffCaloriaDiariaAnterior())
                .circunferenciaAbdominal(entity.getCircunferenciaAbdominal())
                .diffCircunferenciaAbdominalAnterior(entity.getDiffCircunferenciaAbdominalAnterior())
                .idadeCorporal(entity.getIdadeCorporal())
                .diffIdadeCorporalAnterior(entity.getDiffIdadeCorporalAnterior())
                .massaMuscular(entity.getMassaMuscular())
                .diffMassaMuscularAnterior(entity.getDiffMassaMuscularAnterior())
                .idPerfil(entity.getIdPerfil())
                .build();
    }
}
