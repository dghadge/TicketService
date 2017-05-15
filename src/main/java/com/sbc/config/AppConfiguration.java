package com.sbc.config;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.sbc.dao.SeatHoldDAO;
import com.sbc.dao.SeatHoldDAOImpl;

@Configuration
public class AppConfiguration {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	@Primary
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	// If permissions are restricted on primary DataSource - use secondary datasource
	// In this case however we will be using a second datasource for performing our tests 
	@Bean
	@ConfigurationProperties(prefix = "test.datasource")
	public DataSource testDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	public boolean migrateTestDataSource() {
		final Flyway flyway = new Flyway();
		flyway.setDataSource(testDataSource());
		flyway.migrate();
		return true;
	}
	
	@Bean
	@Primary
	public SeatHoldDAO getSeatHoldDAO() {
		return new SeatHoldDAOImpl(dataSource());
	}
	
	@Bean(name="seatHoldDAOTest")
	public SeatHoldDAO getSeatHoldDAOTest() {
		return new SeatHoldDAOImpl(testDataSource());
	}

	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();
	}

	@Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
	
}
