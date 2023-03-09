package br.com.cammarota.alex.ifittrack.usecase.gateway;

import br.com.cammarota.alex.ifittrack.config.exception.AvaliacaoNotFoundException;
import br.com.cammarota.alex.ifittrack.usecase.model.AvaliacaoSaude;

import java.util.List;

public interface ConsultaAvaliacoesSaudePorIdPerfilGateway {
    List<AvaliacaoSaude> getAvaliacoesPorIdPerfil(String idPerfil) throws AvaliacaoNotFoundException;
}
