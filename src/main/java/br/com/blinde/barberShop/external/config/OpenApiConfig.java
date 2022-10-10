package br.com.blinde.barberShop.external.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(getInfo());
    }

    private Info getInfo() {
        return new Info()
                .title("Apis Trendy Girls")
                .version("v1")
                .description("Apis Trendy Girls")
                .termsOfService("")
                .license(getUrl());
    }

    private License getUrl() {
        return new License()
                .name("Apache 2.0")
                .url("");
    }
}