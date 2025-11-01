package com.manish.recipes_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResTempleteConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // allow all paths
                        .allowedOrigins("http://localhost:3000") // allow React origin
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // allowed HTTP methods
                        .allowedHeaders("*");
            }
        };

    }
}
