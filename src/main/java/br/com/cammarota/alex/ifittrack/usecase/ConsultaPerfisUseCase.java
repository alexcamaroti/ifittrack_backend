package br.com.cammarota.alex.ifittrack.usecase;

import br.com.cammarota.alex.ifittrack.config.exception.PerfilNotFoundException;
import br.com.cammarota.alex.ifittrack.usecase.gateway.ConsultaPerfisGateway;
import br.com.cammarota.alex.ifittrack.usecase.model.Perfil;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsultaPerfisUseCase {

    private ConsultaPerfisGateway gateway;

    public ConsultaPerfisUseCase(ConsultaPerfisGateway gateway){
        this.gateway = gateway;
    }

    public List<Perfil> getPerfis() throws PerfilNotFoundException {
        return gateway.consultarPerfis();
    }
}
