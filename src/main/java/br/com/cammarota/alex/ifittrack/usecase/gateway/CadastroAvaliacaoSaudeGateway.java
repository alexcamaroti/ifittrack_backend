package br.com.cammarota.alex.ifittrack.usecase.gateway;

import br.com.cammarota.alex.ifittrack.config.exception.CadastroAvaliacaoSaudeException;
import br.com.cammarota.alex.ifittrack.usecase.model.AvaliacaoSaude;

public interface CadastroAvaliacaoSaudeGateway {

    AvaliacaoSaude cadastrar(AvaliacaoSaude core) throws CadastroAvaliacaoSaudeException;
}
