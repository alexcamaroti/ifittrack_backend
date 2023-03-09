package br.com.cammarota.alex.ifittrack.usecase;

import br.com.cammarota.alex.ifittrack.config.exception.CadastroPerfilException;
import br.com.cammarota.alex.ifittrack.usecase.gateway.CadastroPerfilGateway;
import br.com.cammarota.alex.ifittrack.usecase.model.Perfil;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class CadastroPerfilUseCase {

    private CadastroPerfilGateway cadastroPerfilGateway;

    public CadastroPerfilUseCase(CadastroPerfilGateway cadastroPerfilGateway){
        this.cadastroPerfilGateway = cadastroPerfilGateway;
    }

    public Perfil salvar(Perfil core) throws CadastroPerfilException {
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        Perfil corePreenchido = core.toBuilder().idPerfil(String.valueOf(UUID.randomUUID()))
                .criadoEm(dataHoraAtual)
                .atualizadoEm(dataHoraAtual).build();
        return cadastroPerfilGateway.cadastrar(corePreenchido);
    }
}
