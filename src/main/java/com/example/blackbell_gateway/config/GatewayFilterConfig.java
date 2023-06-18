package com.example.blackbell_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayFilterConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(route -> route.path("/black-bell/**")
                        .filters(filter -> filter.addRequestHeader("black-bell-request", "black-bell-request-header")
                                                 .addResponseHeader("black-bell-response", "black-bell-response-header"))
                        .uri("http://localhost:8081"))
                .build();
    }
}
