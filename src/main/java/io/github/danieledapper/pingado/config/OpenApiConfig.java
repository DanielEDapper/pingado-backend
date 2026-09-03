package io.github.danieledapper.pingado.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig
{
    @Bean
    public OpenAPI pingadoOpenApi()
    {
        return new OpenAPI()
                .info(new Info()
                        .title("Pingado API")
                        .description("API REST da plataforma de assinatura de cafés especiais brasileiros Pingado")
                        .version("v0.0.1")
                        .contact(new Contact()
                                .name("Daniel Dapper")
                                .email("danielerthaldapper2008@gmail.com")
                                .url("https://github.com/DanielEDapper/pingado-backend")));
    }
}