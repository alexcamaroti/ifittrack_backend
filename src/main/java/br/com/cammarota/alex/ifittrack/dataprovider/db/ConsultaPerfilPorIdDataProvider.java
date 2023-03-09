package br.com.cammarota.alex.ifittrack.dataprovider.db;

import br.com.cammarota.alex.ifittrack.config.exception.InvalidPerfilException;
import br.com.cammarota.alex.ifittrack.config.utils.Constants;
import br.com.cammarota.alex.ifittrack.dataprovider.db.repository.PerfilRepository;
import br.com.cammarota.alex.ifittrack.usecase.gateway.ConsultaPerfilPorIdGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaPerfilPorIdDataProvider implements ConsultaPerfilPorIdGateway {

    private static final Logger logger = LoggerFactory.getLogger(ConsultaPerfilPorIdDataProvider.class.getName());
    @Autowired
    private PerfilRepository repository;

    @Override
    public Boolean exists(String idPerfil) throws InvalidPerfilException {
        logger.debug(Constants.MSG_PERFIL_VERIFICANDO_EXISTE.concat(idPerfil));
        Boolean exists = repository.existsByIdPerfil(idPerfil);
        if(!exists) {
            throw new InvalidPerfilException(Constants.MSG_PERFIL_NOT_FOUND.concat(idPerfil));
        }
        return Boolean.TRUE;
    }
}
