package br.com.cammarota.alex.ifittrack.entrypoint.http.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AvaliacaoSaudeRequest {

    private BigDecimal peso;
    private BigDecimal imc;
    private BigDecimal gorduraCorporal;
    private BigDecimal gorduraVisceral;
    private BigDecimal massaMuscular;
    private Long caloriaDiaria;
    private BigDecimal circunferenciaAbdominal;
    private Integer idadeCorporal;
}
