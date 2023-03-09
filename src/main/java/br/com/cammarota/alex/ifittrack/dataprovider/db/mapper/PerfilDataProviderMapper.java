package br.com.cammarota.alex.ifittrack.dataprovider.db.mapper;


import br.com.cammarota.alex.ifittrack.dataprovider.db.repository.entity.PerfilEntity;
import br.com.cammarota.alex.ifittrack.usecase.enums.Sexo;
import br.com.cammarota.alex.ifittrack.usecase.model.Perfil;

public class PerfilDataProviderMapper {

    private PerfilDataProviderMapper(){
    }

    public static PerfilEntity fromCoreToEntity(Perfil core){

        return PerfilEntity.builder().idPerfil(core.getIdPerfil())
                .nome(core.getNome()).sobrenome(core.getSobrenome())
                .idade(core.getIdade()).altura(core.getAltura()).sexo(core.getSexo().getGenero())
                .criadoEm(core.getCriadoEm())
                .atualizadoEm(core.getAtualizadoEm()).build();
    }

    public static Perfil fromEntityToCore(PerfilEntity entity){
        if(entity == null) {
            throw new NullPointerException("Erro ao converter PerfilDB");
        }

        return Perfil.builder().idPerfil(entity.getIdPerfil())
                .nome(entity.getNome())
                .sobrenome(entity.getSobrenome())
                .idade(entity.getIdade())
                .altura(entity.getAltura())
                .sexo(Sexo.fromCharacter(entity.getSexo()))
                .criadoEm(entity.getCriadoEm())
                .atualizadoEm(entity.getAtualizadoEm()).build();
    }
}
