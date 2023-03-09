package br.com.cammarota.alex.ifittrack.entrypoint.http.model;

import br.com.cammarota.alex.ifittrack.usecase.enums.Sexo;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PerfilResponse {

    private String idPerfil;
    private String nome;
    private String sobrenome;
    private Integer idade;
    private Double altura;
    private Character sexo;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
}
