package br.com.cammarota.alex.ifittrack.dataprovider.db;

import br.com.cammarota.alex.ifittrack.config.exception.CadastroPerfilException;
import br.com.cammarota.alex.ifittrack.dataprovider.db.mapper.PerfilDataProviderMapper;
import br.com.cammarota.alex.ifittrack.dataprovider.db.repository.entity.PerfilEntity;
import br.com.cammarota.alex.ifittrack.dataprovider.db.repository.PerfilRepository;
import br.com.cammarota.alex.ifittrack.usecase.gateway.CadastroPerfilGateway;
import br.com.cammarota.alex.ifittrack.usecase.model.Perfil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CadastroPerfilDataProvider implements CadastroPerfilGateway {

   private static final Logger logger = LoggerFactory.getLogger(CadastroPerfilDataProvider.class.getName());

    @Autowired
    private PerfilRepository repository;

    @Override
    public Perfil cadastrar(Perfil perfil) throws CadastroPerfilException {
        try {
            PerfilEntity entity = PerfilDataProviderMapper.fromCoreToEntity(perfil);
            PerfilEntity perfilSalvo = repository.save(entity);
            logger.info("Cadastro de perfil realizado. {}", perfilSalvo.getIdPerfil());
            return PerfilDataProviderMapper.fromEntityToCore(perfilSalvo);
        } catch (Exception ex){
            String msg = "Erro ao Cadastrar o Perfil";
            logger.error(msg + " {}", ex);
            throw new CadastroPerfilException(msg);

        }
    }
}


