package com.djachtoma.neo4j;

import org.neo4j.cypherdsl.core.renderer.Dialect;
import org.neo4j.springframework.data.repository.config.EnableReactiveNeo4jRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableReactiveNeo4jRepositories(basePackages = "com.djachtoma")
public class Neo4JConfiguration {


    @Bean
    public org.neo4j.cypherdsl.core.renderer.Configuration configuration() {
        return org.neo4j.cypherdsl.core.renderer.Configuration.newConfig()
                .withDialect(Dialect.NEO4J_5)
                .build();
    }
}
