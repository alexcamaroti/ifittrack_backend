package br.com.cammarota.alex.ifittrack.dataprovider.db;

import br.com.cammarota.alex.ifittrack.config.exception.CadastroAvaliacaoSaudeException;
import br.com.cammarota.alex.ifittrack.dataprovider.db.mapper.AvaliacaoSaudeDataProviderMapper;
import br.com.cammarota.alex.ifittrack.dataprovider.db.repository.AvaliacaoSaudeRepository;
import br.com.cammarota.alex.ifittrack.dataprovider.db.repository.entity.AvaliacaoSaudeEntity;
import br.com.cammarota.alex.ifittrack.usecase.gateway.CadastroAvaliacaoSaudeGateway;
import br.com.cammarota.alex.ifittrack.usecase.model.AvaliacaoSaude;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastroAvaliacaoSaudeDataprovider implements CadastroAvaliacaoSaudeGateway {

    private static final Logger logger = LoggerFactory.getLogger(CadastroAvaliacaoSaudeDataprovider.class.getName());

    @Autowired
    private AvaliacaoSaudeRepository repository;

    @Override
    public AvaliacaoSaude cadastrar(AvaliacaoSaude core) throws CadastroAvaliacaoSaudeException {
        try {
            AvaliacaoSaudeEntity entity = AvaliacaoSaudeDataProviderMapper.fromCoreToEntity(core);
            AvaliacaoSaudeEntity avaliacaoSalva = repository.save(entity);
            logger.info("Cadastro de avaliacao {} para perfil {} realizado. ", avaliacaoSalva.getIdAvaliacao(), avaliacaoSalva.getIdPerfil());
            return AvaliacaoSaudeDataProviderMapper.fromEntityToCore(avaliacaoSalva);
        } catch (Exception ex) {
            String msg = "Erro ao cadastrar avaliacao para perfil: ".concat(core.getIdPerfil());
            logger.error(msg + " {}", ex);
            throw new CadastroAvaliacaoSaudeException(msg);
        }
    }
}
