package br.com.cammarota.alex.ifittrack.entrypoint.http.mapper;

import br.com.cammarota.alex.ifittrack.entrypoint.http.model.PerfilRequest;
import br.com.cammarota.alex.ifittrack.entrypoint.http.model.PerfilResponse;
import br.com.cammarota.alex.ifittrack.usecase.enums.Sexo;
import br.com.cammarota.alex.ifittrack.usecase.model.Perfil;

public class PerfilEntryPointMapper {

    private PerfilEntryPointMapper() {
    }

    public static Perfil fromRequestToCore(PerfilRequest request) throws Exception {
        if (request == null){
            throw new Exception("Erro Na Aplicacao. PerfilRequest Nulo");
        }
        return Perfil.builder()
                .nome(request.getNome())
                .sobrenome(request.getSobrenome())
                .idade(request.getIdade())
                .altura(request.getAltura())
                .sexo(Sexo.fromCharacter(request.getSexo()))
                .build();
    }

    public static PerfilResponse fromCoreToResponse(Perfil core) throws Exception {
        if (core == null){
            throw new Exception("Erro no fromCoreToResponse. Perfil Nulo");
        }
        
        return PerfilResponse.builder().idPerfil(core.getIdPerfil())
                .nome(core.getNome())
                .sobrenome(core.getSobrenome())
                .idade(core.getIdade())
                .altura(core.getAltura())
                .sexo(core.getSexo().getGenero())
                .criadoEm(core.getCriadoEm())
                .atualizadoEm(core.getAtualizadoEm()).build();
    }
}
