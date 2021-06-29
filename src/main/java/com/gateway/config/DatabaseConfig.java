package com.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gateway.exception.DatabaseException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public HikariDataSource createConnection() throws DatabaseException {
        try {
            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/nomeDatabase");
            hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
            hikariConfig.setUsername("mysql");
            hikariConfig.setPassword("mysql");
            hikariConfig.validate();
            return new HikariDataSource(hikariConfig);
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

}
