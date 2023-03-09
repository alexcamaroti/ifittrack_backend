package br.com.cammarota.alex.ifittrack.dataprovider.db.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "TB_PERFIL")
public class PerfilEntity {

    @Id
    @Column(name = "perfil_id")
    private String idPerfil;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "altura")
    private Double altura;

    @Column(name = "sexo")
    private Character sexo;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;
}
