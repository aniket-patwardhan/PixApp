package com.demesne.pix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.demesne*"})
@EntityScan("com.demesne*")
@EnableJpaRepositories("com.demesne*")
@SpringBootApplication
public class PixApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(PixApplication.class, args);
	}
	
	@Override 
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(PixApplication.class);
	}
}
