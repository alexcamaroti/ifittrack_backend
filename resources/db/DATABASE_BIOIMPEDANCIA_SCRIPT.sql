create table IF NOT EXISTS TB_PERFIL(
	perfil_id VARCHAR(50) PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	sobrenome VARCHAR(50) NOT NULL, 
	idade INT NOT NULL, 
	altura DECIMAL NOT NULL, 
	sexo CHAR(1) NOT NULL,
	criado_em TIMESTAMP NOT NULL,
	atualizado_em TIMESTAMP NOT NULL);
	
	
SELECT * FROM TB_PERFIL;

DELETE FROM TB_PERFIL WHERE perfil_id = '6595b73d-04c1-4c99-b232-f5828091c687'
SELECT * FROM TB_AVALIACAO_SAUDE;
DELETE FROM TB_AVALIACAO_SAUDE WHERE perfil_id = 'f2f78bcf-76c1-40cd-ab48-bed205d7a256'
DELETE FROM TB_AVALIACAO_SAUDE WHERE avaliacao_id = '6dec3dc7-b79f-457c-8b5f-df6524fa965e'