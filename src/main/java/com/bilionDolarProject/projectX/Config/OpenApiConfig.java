package com.bilionDolarProject.projectX.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI projectXOpenAPI() {
        Server localServer = new Server()
            .url("http://localhost:8081")
            .description("Local Development Server");

        return new OpenAPI()
                .servers(List.of(localServer))
                .info(new Info()
                    .title("ProjectX API")
                    .description("Gearbox and Vehicle Speed Calculator API")
                    .version("v1.0.0")
                    .license(new License()
                        .name("Apache 2.0")
                        .url("http://springdoc.org")));
    }
}
