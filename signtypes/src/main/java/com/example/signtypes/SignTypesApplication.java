package com.example.signtypes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SignTypesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SignTypesApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(@Value("${signs.signs.url}") String baseURL) {
        return new RestTemplateBuilder().rootUri(baseURL).build();
    }

}
