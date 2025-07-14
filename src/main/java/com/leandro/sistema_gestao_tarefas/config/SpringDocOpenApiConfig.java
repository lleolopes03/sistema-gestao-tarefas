package com.leandro.sistema_gestao_tarefas.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocOpenApiConfig {
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("sistema-gestão-tarefa")
                        .description("sistema de gestao de tarefas")
                        .version("v1")
                        .contact(new Contact()
                                .name("Leandro Lopes")
                                .email("leandrolopes.it@outlook.com")));
    }



}
