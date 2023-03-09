package br.com.cammarota.alex.ifittrack.usecase.gateway;

import br.com.cammarota.alex.ifittrack.config.exception.PerfilNotFoundException;
import br.com.cammarota.alex.ifittrack.usecase.model.Perfil;

import java.util.List;

public interface ConsultaPerfisGateway {
    List<Perfil> consultarPerfis() throws PerfilNotFoundException;
}
