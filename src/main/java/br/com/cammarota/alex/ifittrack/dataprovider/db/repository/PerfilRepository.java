package br.com.cammarota.alex.ifittrack.dataprovider.db.repository;

import br.com.cammarota.alex.ifittrack.dataprovider.db.repository.entity.PerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<PerfilEntity, Long> {

    Boolean existsByIdPerfil(String idPerfil);
}
