package br.com.cammarota.alex.ifittrack.usecase.model;

import br.com.cammarota.alex.ifittrack.usecase.enums.Sexo;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class Perfil {

    private String idPerfil;
    private String nome;
    private String sobrenome;
    private Integer idade;
    private Double altura;
    private Sexo sexo;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
}
