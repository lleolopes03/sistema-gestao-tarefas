package com.leandro.sistema_gestao_tarefas.config;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocOpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Sistema de Gestão de Tarefas")
                        .version("1.0.0")
                        .description("API REST para gerenciamento de tarefas e usuários"))
                .components(new Components().addSecuritySchemes("bearerAuth", securityScheme()))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
    }
    @Bean
    public SecurityScheme securityScheme() {
        return new SecurityScheme()
                .name("Authorization")
                .description("Insira um Bearer token válido para prosseguir")
                .scheme("bearer")
                .type(SecurityScheme.Type.HTTP)
                .in(SecurityScheme.In.HEADER)
                .bearerFormat("JWT");
    }



}
