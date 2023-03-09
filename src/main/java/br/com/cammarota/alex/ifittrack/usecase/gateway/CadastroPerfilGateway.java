package br.com.cammarota.alex.ifittrack.usecase.gateway;

import br.com.cammarota.alex.ifittrack.config.exception.CadastroPerfilException;
import br.com.cammarota.alex.ifittrack.usecase.model.Perfil;

public interface CadastroPerfilGateway {

    Perfil cadastrar(Perfil perfil) throws CadastroPerfilException;
}
