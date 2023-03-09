package br.com.cammarota.alex.ifittrack.usecase.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class AvaliacaoSaude {

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