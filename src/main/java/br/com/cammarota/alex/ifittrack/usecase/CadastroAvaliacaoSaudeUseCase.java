package br.com.cammarota.alex.ifittrack.usecase;

import br.com.cammarota.alex.ifittrack.config.exception.AvaliacaoNotFoundException;
import br.com.cammarota.alex.ifittrack.config.exception.CadastroAvaliacaoSaudeException;
import br.com.cammarota.alex.ifittrack.config.exception.InvalidPerfilException;
import br.com.cammarota.alex.ifittrack.usecase.gateway.CadastroAvaliacaoSaudeGateway;
import br.com.cammarota.alex.ifittrack.usecase.gateway.ConsultaAvaliacoesSaudePorIdPerfilGateway;
import br.com.cammarota.alex.ifittrack.usecase.gateway.ConsultaPerfilPorIdGateway;
import br.com.cammarota.alex.ifittrack.usecase.model.AvaliacaoSaude;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import static br.com.cammarota.alex.ifittrack.usecase.utils.ValidatorUtils.checkNullAndSubtract;


@Component
public class CadastroAvaliacaoSaudeUseCase {

    private CadastroAvaliacaoSaudeGateway cadastroAvaliacaoSaudeGateway;

    private ConsultaAvaliacoesSaudePorIdPerfilGateway consultaAvaliacoesSaudePorIdPerfilGateway;

    private ConsultaPerfilPorIdGateway consultaPerfilPorIdGateway;

    public CadastroAvaliacaoSaudeUseCase(CadastroAvaliacaoSaudeGateway cadastroAvaliacaoSaudeGateway,
                                         ConsultaAvaliacoesSaudePorIdPerfilGateway consultaAvaliacoesSaudePorIdPerfilGateway,
                                         ConsultaPerfilPorIdGateway consultaPerfilPorIdGateway){
        this.cadastroAvaliacaoSaudeGateway = cadastroAvaliacaoSaudeGateway;
        this.consultaAvaliacoesSaudePorIdPerfilGateway = consultaAvaliacoesSaudePorIdPerfilGateway;
        this.consultaPerfilPorIdGateway = consultaPerfilPorIdGateway;
    }

    public AvaliacaoSaude cadastrar(AvaliacaoSaude core) throws CadastroAvaliacaoSaudeException, InvalidPerfilException {
        consultaPerfilPorIdGateway.exists(core.getIdPerfil());

        AvaliacaoSaude avaliacaoPopulada = null;
        List<AvaliacaoSaude> avaliacoesAnteriores = getAvaliacaoSaudesAnteriores(core.getIdPerfil());

        if(avaliacoesAnteriores != null && !avaliacoesAnteriores.isEmpty()) {
            LocalDateTime dataHoraProcessamento = LocalDateTime.now();
            AvaliacaoSaude avaliacaoRecente = retornarAvaliacaoMaisRecente(avaliacoesAnteriores, dataHoraProcessamento);
            avaliacaoPopulada = core.toBuilder()
                    .idAvaliacao(String.valueOf(UUID.randomUUID()))
                    .dataHora(dataHoraProcessamento)
                    .diffPesoAnterior(checkNullAndSubtract(avaliacaoRecente.getPeso(), core.getPeso()))
                    .diffIMCAnterior(checkNullAndSubtract(avaliacaoRecente.getImc(), core.getImc()))
                    .diffGorduraCorporalAnterior(checkNullAndSubtract(avaliacaoRecente.getGorduraCorporal(), core.getGorduraCorporal()))
                    .diffMassaMuscularAnterior(checkNullAndSubtract(avaliacaoRecente.getMassaMuscular(), core.getMassaMuscular()))
                    .diffGorduraVisceralAnterior(checkNullAndSubtract(avaliacaoRecente.getGorduraVisceral(), core.getGorduraVisceral()))
                    .diffCaloriaDiariaAnterior(checkNullAndSubtract(BigDecimal.valueOf(avaliacaoRecente.getCaloriaDiaria()), BigDecimal.valueOf(core.getCaloriaDiaria())))
                    .diffCircunferenciaAbdominalAnterior(checkNullAndSubtract(avaliacaoRecente.getCircunferenciaAbdominal(), core.getCircunferenciaAbdominal()))
                    .diffIdadeCorporalAnterior(BigDecimal.valueOf(checkNullAndSubtract(avaliacaoRecente.getIdadeCorporal(), core.getIdadeCorporal()))).build();
        } else {
            avaliacaoPopulada = core.toBuilder()
                    .idAvaliacao(String.valueOf(UUID.randomUUID()))
                    .dataHora(LocalDateTime.now())
                    .diffPesoAnterior(BigDecimal.ZERO)
                    .diffIMCAnterior(BigDecimal.ZERO)
                    .diffGorduraCorporalAnterior(BigDecimal.ZERO)
                    .diffMassaMuscularAnterior(BigDecimal.ZERO)
                    .diffGorduraVisceralAnterior(BigDecimal.ZERO)
                    .diffCaloriaDiariaAnterior(BigDecimal.ZERO)
                    .diffCircunferenciaAbdominalAnterior(BigDecimal.ZERO)
                    .diffIdadeCorporalAnterior(BigDecimal.ZERO).build();
        }
        return cadastroAvaliacaoSaudeGateway.cadastrar(avaliacaoPopulada);
    }

    private List<AvaliacaoSaude> getAvaliacaoSaudesAnteriores(String idPerfil) {
        try {
            return consultaAvaliacoesSaudePorIdPerfilGateway.getAvaliacoesPorIdPerfil(idPerfil);
        }
        catch (AvaliacaoNotFoundException ex){
            return null;
        }

    }

    private AvaliacaoSaude retornarAvaliacaoMaisRecente(List<AvaliacaoSaude> avaliacoesAnteriores, LocalDateTime horaAtual) {
        AvaliacaoSaude avaliacaoRecente = avaliacoesAnteriores.stream().min(Comparator.comparingLong(
                avaliacaoAnterior -> Duration.between(avaliacaoAnterior.getDataHora(), horaAtual).toMillis())).get();
        return avaliacaoRecente;
    }
}
