package br.com.cammarota.alex.ifittrack.entrypoint.http.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AvaliacaoSaudeResponse {

    private String idAvaliacao;
    private LocalDateTime dataHora;
    private BigDecimal peso;
    private BigDecimal diffPesoAnterior;
    private BigDecimal imc;
    private BigDecimal diffIMCAnterior;
    private BigDecimal gorduraCorporal;
    private BigDecimal diffGorduraCorporalAnterior;
    private BigDecimal massaMuscular;
    private BigDecimal diffMassaMuscularAnterior;
    private BigDecimal gorduraVisceral;
    private BigDecimal diffGorduraVisceralAnterior;
    private Long caloriaDiaria;
    private BigDecimal diffCaloriaDiariaAnterior;
    private BigDecimal circunferenciaAbdominal;
    private BigDecimal diffCircunferenciaAbdominalAnterior;
    private Integer idadeCorporal;
    private BigDecimal diffIdadeCorporalAnterior;
    private String idPerfil;

}