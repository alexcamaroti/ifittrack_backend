package br.com.cammarota.alex.ifittrack.usecase;

import br.com.cammarota.alex.ifittrack.config.exception.AvaliacaoNotFoundException;
import br.com.cammarota.alex.ifittrack.usecase.gateway.ConsultaAvaliacoesSaudePorIdPerfilGateway;
import br.com.cammarota.alex.ifittrack.usecase.model.AvaliacaoSaude;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsultaAvaliacoesSaudeUseCase {

    private ConsultaAvaliacoesSaudePorIdPerfilGateway gateway;

    public ConsultaAvaliacoesSaudeUseCase(ConsultaAvaliacoesSaudePorIdPerfilGateway gateway){
        this.gateway = gateway;
    }

    public List<AvaliacaoSaude> getAvaliacoesPorIdPerfil(String idPerfil) throws AvaliacaoNotFoundException {
        return gateway.getAvaliacoesPorIdPerfil(idPerfil);
    }
}
