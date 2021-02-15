package com.bfs.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.result.view.RedirectView;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class GlobalPreFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders headers = exchange.getRequest().getHeaders();
        if(!headers.containsKey("Authorization")) {
            ServerHttpResponse response = exchange.getResponse();
            URI uri = null;
            try {
                uri = new URI("http://localhost:9999/auth?redirect="+exchange.getRequest().getURI());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            response.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
            response.getHeaders().setLocation(uri);
            return response.setComplete();
        }
        return chain.filter(exchange);
    }
}
