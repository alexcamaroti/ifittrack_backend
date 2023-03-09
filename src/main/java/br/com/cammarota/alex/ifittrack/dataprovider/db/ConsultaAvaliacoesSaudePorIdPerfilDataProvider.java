package br.com.cammarota.alex.ifittrack.dataprovider.db;

import br.com.cammarota.alex.ifittrack.config.exception.AvaliacaoNotFoundException;
import br.com.cammarota.alex.ifittrack.config.utils.Constants;
import br.com.cammarota.alex.ifittrack.dataprovider.db.mapper.AvaliacaoSaudeDataProviderMapper;
import br.com.cammarota.alex.ifittrack.dataprovider.db.repository.AvaliacaoSaudeRepository;
import br.com.cammarota.alex.ifittrack.dataprovider.db.repository.entity.AvaliacaoSaudeEntity;
import br.com.cammarota.alex.ifittrack.usecase.gateway.ConsultaAvaliacoesSaudePorIdPerfilGateway;
import br.com.cammarota.alex.ifittrack.usecase.model.AvaliacaoSaude;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class ConsultaAvaliacoesSaudePorIdPerfilDataProvider implements ConsultaAvaliacoesSaudePorIdPerfilGateway {

    private static final Logger logger = LoggerFactory.getLogger(ConsultaAvaliacoesSaudePorIdPerfilDataProvider.class.getName());

    @Autowired
    private AvaliacaoSaudeRepository repository;

    @Override
    public List<AvaliacaoSaude> getAvaliacoesPorIdPerfil(String idPerfil) throws AvaliacaoNotFoundException {
        List<AvaliacaoSaudeEntity> avaliacoes = repository.findByIdPerfil(idPerfil);
        if (avaliacoes.isEmpty()) {
            String msgWarning = Constants.MSG_AVALIACOES_NOT_FOUND.concat(idPerfil);
            logger.warn(msgWarning);
            throw new AvaliacaoNotFoundException(msgWarning);
        }
            return avaliacoes.stream().map(AvaliacaoSaudeDataProviderMapper::fromEntityToCore).collect(toList());
    }
}
