package com.example.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
            @Value("${signs.signs.url}") String signsURL,
            @Value("${signs.signtypes.url}") String signTypesURL,
            @Value("${signs.gateway.host}") String host
    ) {
        return builder.routes()
                .route("signs", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/signs",
                                "/api/signs/{id}",
                                "/api/signtypes/{id}/signs"
                        )
                        .uri(signsURL)
                )
                .route("signtypes", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/signtypes",
                                "/api/signtypes/{id}"
                        )
                        .uri(signTypesURL)
                )
                .build();
    }

}
