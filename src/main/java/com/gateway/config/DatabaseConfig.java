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
            hikariConfig.setJdbcUrl("jdbc:sqlserver://127.0.0.1:1433;databaseName=data");
			hikariConfig.setUsername("sa");
			hikariConfig.setPassword("Password11!!!!");
			hikariConfig.validate();
			return new HikariDataSource(hikariConfig);
		} catch (Exception e) {
			throw new DatabaseException(e.getMessage());
		}
	}

}
