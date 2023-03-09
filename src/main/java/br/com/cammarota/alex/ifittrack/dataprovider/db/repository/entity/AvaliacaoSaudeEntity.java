package br.com.cammarota.alex.ifittrack.dataprovider.db.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "TB_AVALIACAO_SAUDE")
public class AvaliacaoSaudeEntity {

    @Id
    @Column(name = "avaliacao_id")
    private String idAvaliacao;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @Column(name = "peso")
    private BigDecimal peso;

    @Column(name = "diff_peso_ant")
    private BigDecimal diffPesoAnterior;

    @Column(name = "imc")
    private BigDecimal imc;

    @Column(name = "diff_imc_ant")
    private BigDecimal diffIMCAnterior;

    @Column(name = "gordura_corporal")
    private BigDecimal gorduraCorporal;

    @Column(name = "diff_gordura_corporal_ant")
    private BigDecimal diffGorduraCorporalAnterior;

    @Column(name = "massa_muscular")
    private BigDecimal massaMuscular;

    @Column(name = "diff_massa_muscular_anterior")
    private BigDecimal diffMassaMuscularAnterior;

    @Column(name = "gordura_visceral")
    private BigDecimal gorduraVisceral;

    @Column(name = "diff_gordura_visceral_ant")
    private BigDecimal diffGorduraVisceralAnterior;

    @Column(name = "caloria_diaria")
    private Long caloriaDiaria;

    @Column(name = "diff_caloria_diaria_ant")
    private BigDecimal diffCaloriaDiariaAnterior;

    @Column(name = "circunferencia_abdominal")
    private BigDecimal circunferenciaAbdominal;

    @Column(name = "diff_circunferencia_abdominal_ant")
    private BigDecimal diffCircunferenciaAbdominalAnterior;

    @Column(name = "idade_corporal")
    private Integer idadeCorporal;

    @Column(name = "diff_idade_corporal_ant")
    private BigDecimal diffIdadeCorporalAnterior;

    @Column(name = "perfil_id")
    private String idPerfil;

}
