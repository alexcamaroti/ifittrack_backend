package br.com.cammarota.alex.ifittrack.dataprovider.db.repository;

import br.com.cammarota.alex.ifittrack.dataprovider.db.repository.entity.AvaliacaoSaudeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoSaudeRepository extends JpaRepository<AvaliacaoSaudeEntity, Long> {

    List<AvaliacaoSaudeEntity> findByIdPerfil(String idPerfil);
}
