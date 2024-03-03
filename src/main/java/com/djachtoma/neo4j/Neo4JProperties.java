package com.djachtoma.neo4j;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "neo4j.config")
public class Neo4JProperties {

    private String uri;
    private String username;
    private String password;
}
