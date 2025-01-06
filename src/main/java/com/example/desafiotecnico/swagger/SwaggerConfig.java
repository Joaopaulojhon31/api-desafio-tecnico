package com.example.desafiotecnico.swagger;


import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SwaggerConfig {

	 @Bean
	    public OpenAPI customOpenAPI() {
	        return new OpenAPI()
	            .info(new Info()
	                .title("Desafio Técnico")
	                .version("1.0")
	                .description("Como não foi solicitado entrada de dados, deixei o dados definidos dentro do codigo"));
	    }
}
