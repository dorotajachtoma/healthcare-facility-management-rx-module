package com.djachtoma;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.neo4j.springframework.data.config.EnableNeo4jAuditing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableNeo4jAuditing
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Healthcare Facility Management RX Module"))
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
