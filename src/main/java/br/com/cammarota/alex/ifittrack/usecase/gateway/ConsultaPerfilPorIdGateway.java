package br.com.cammarota.alex.ifittrack.usecase.gateway;

import br.com.cammarota.alex.ifittrack.config.exception.InvalidPerfilException;

public interface ConsultaPerfilPorIdGateway {

    Boolean exists(String idPerfil) throws InvalidPerfilException;
}
