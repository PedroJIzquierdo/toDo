package com.cjp.ToDo.WebConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {



	    
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**") // Permitir CORS para todas las rutas
	                .allowedOrigins("http://localhost:4200") // Permitir solo la aplicación Angular
	                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
	                .allowedHeaders("*") // Headers permitidos
	                .allowCredentials(true); // Permitir credenciales
	    }
	}


