package br.com.cammarota.alex.ifittrack.config.aws;

import br.com.cammarota.alex.ifittrack.config.aws.model.AwsSecretsModel;
import br.com.cammarota.alex.ifittrack.config.utils.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

import javax.sql.DataSource;

@Configuration
public class AWSConfig {

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;
    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;

    private static final Logger logger = LoggerFactory.getLogger(AWSConfig.class.getName());

    @Bean
    public DataSource dataSource() throws Exception {
        AwsSecretsModel secret = getSecret();
        String url = "jdbc:postgresql://".concat(secret.getHost())
                .concat(":").concat(secret.getPort()).concat("/").concat(secret.getDbname());
       return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url(url)
                .username(secret.getUsername())
                .password(secret.getPassword())
                .build();
//        this.dbUrl = url;
//        this.dbUsername = secret.getUsername();
//        this.dbPassword = secret.getPassword();
    }

    public AwsSecretsModel getSecret() throws Exception {
        String secretName = "db-secrets-manager";
        Region region = Region.of("sa-east-1");
        // Create a Secrets Manager client
        SecretsManagerClient client = SecretsManagerClient.builder()
                .region(region)
                .credentialsProvider(() -> new AwsCredentials() {
                    @Override
                    public String accessKeyId() {
                        return accessKey;
                    }

                    @Override
                    public String secretAccessKey() {
                        return secretKey;
                    }
                })
                .build();

        GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
                .secretId(secretName)
                .build();

        GetSecretValueResponse getSecretValueResponse;

        try {
            getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
        } catch (Exception e) {
            logger.error(Constants.ERRO_PROCESSAR_SECRET, e);
            throw e;
        }

        String secret = getSecretValueResponse.secretString();
        if(secret == null){
            throw new Exception(Constants.MSG_ERRO_AWS_SECRET);
        }
        return new ObjectMapper().readValue(secret, AwsSecretsModel.class);
    }
}
