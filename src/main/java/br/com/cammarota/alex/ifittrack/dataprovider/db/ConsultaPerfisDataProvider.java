package br.com.cammarota.alex.ifittrack.dataprovider.db;

import br.com.cammarota.alex.ifittrack.config.exception.PerfilNotFoundException;
import br.com.cammarota.alex.ifittrack.config.utils.Constants;
import br.com.cammarota.alex.ifittrack.dataprovider.db.mapper.PerfilDataProviderMapper;
import br.com.cammarota.alex.ifittrack.dataprovider.db.repository.entity.PerfilEntity;
import br.com.cammarota.alex.ifittrack.usecase.gateway.ConsultaPerfisGateway;
import br.com.cammarota.alex.ifittrack.usecase.model.Perfil;
import br.com.cammarota.alex.ifittrack.dataprovider.db.repository.PerfilRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class ConsultaPerfisDataProvider implements ConsultaPerfisGateway {

    private static final Logger logger = LoggerFactory.getLogger(ConsultaPerfisDataProvider.class.getName());
    @Autowired
    private PerfilRepository repository;

    @Override
    public List<Perfil> consultarPerfis() throws PerfilNotFoundException {
        List<PerfilEntity> perfis = repository.findAll();

        if(perfis.isEmpty()){
            logger.warn(Constants.MSG_PERFIS_NOT_FOUND);
            throw new PerfilNotFoundException(Constants.MSG_PERFIS_NOT_FOUND);
        }
        return perfis.stream().map(PerfilDataProviderMapper::fromEntityToCore).collect(toList());
    }
}
