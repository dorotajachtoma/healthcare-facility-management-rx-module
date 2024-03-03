package com.djachtoma.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("healthcare.facility.management.database")
public class RedisProperties {

    private String host;
    private Integer port;
    private Integer timeout;
    private String password;


}
