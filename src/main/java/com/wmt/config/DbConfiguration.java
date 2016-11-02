package com.wmt.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.wmt.dao.SeatHoldDAO;
import com.wmt.dao.SeatHoldDAOImpl;

@Configuration
public class DbConfiguration {

	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	@Primary
	public DataSource dataSource(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	@ConfigurationProperties(prefix="flyway.datasource")
	@FlywayDataSource
	public DataSource flywayDataSource(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean
    public SeatHoldDAO getSeatHoldDAO() {
        return new SeatHoldDAOImpl(dataSource());
    }
	
}
