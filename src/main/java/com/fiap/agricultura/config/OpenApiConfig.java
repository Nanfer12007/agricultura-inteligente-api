package com.fiap.agricultura.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("Agricultura Inteligente API")
                                .version("1.0")
                                .description(
                                        "API para monitoramento agrícola utilizando dados satelitais e inteligência artificial.")
                                .contact(
                                        new Contact()
                                                .name("FIAP")
                                                .email("contato@fiap.com")));
    }
}