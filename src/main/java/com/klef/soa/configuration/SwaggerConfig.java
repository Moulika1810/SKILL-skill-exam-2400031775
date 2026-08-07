package com.klef.soa.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        Contact contact = new Contact();
        contact.setName("SOA REST API");
        contact.setEmail("author@klef.com");
        contact.setUrl("https://www.klef.ac.in");

        Info info = new Info()
                .title("Author Service REST API")
                .version("1.0")
                .description("Spring Boot REST API for Author Management")
                .contact(contact)
                .license(new License()
                        .name("Apache 2.0")
                        .url("https://www.apache.org/licenses/LICENSE-2.0"));

        return new OpenAPI().info(info);
    }
}