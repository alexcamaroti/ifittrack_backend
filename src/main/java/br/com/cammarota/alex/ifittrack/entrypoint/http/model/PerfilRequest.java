package br.com.cammarota.alex.ifittrack.entrypoint.http.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PerfilRequest {

    @NotBlank(message = "Campo nome é obrigatorio")
    @Size(min = 3, max = 50)
    private String nome;
    @NotBlank(message = "Campo sobrenome é obrigatorio")
    @Size(min = 3, max = 50)
    private String sobrenome;
    @Min(value = 15, message = "Campo idade deve ser entre entre 15 e 99.") @Max(99)
    private Integer idade;
    @DecimalMin(value = "0.5", message = "Campo altura com no minimo 0.5 e max 2.5") @DecimalMax("2.50")
    private Double altura;
    @NotNull(message = "Campo sexo deve ser M ou F.")
    private Character sexo;
}
