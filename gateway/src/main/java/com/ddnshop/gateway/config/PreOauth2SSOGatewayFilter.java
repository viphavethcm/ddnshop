package com.ddnshop.gateway.config;

import com.ddnshop.gateway.jwt.JwtOAuth2User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Component("Oauth2SSOGatewayFilterFactory")
public class PreOauth2SSOGatewayFilter
        extends AbstractGatewayFilterFactory<PreOauth2SSOGatewayFilter.Config> {

    private final Logger LOGGER = LoggerFactory.getLogger(PreOauth2SSOGatewayFilter.class);


    public PreOauth2SSOGatewayFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
//        return (exchange, chain) -> ReactiveSecurityContextHolder.getContext()
//                .filter(Objects::nonNull)
//                .map(SecurityContext::getAuthentication)
//                .filter(authentication -> authentication instanceof OAuth2AuthenticationToken)
//                .map(authentication -> (OAuth2AuthenticationToken) authentication)
//                .map(OAuth2AuthenticationToken::getPrincipal)
//                .filter(oAuth2User -> Objects.nonNull(oAuth2User) && oAuth2User instanceof JwtOAuth2User)
//                .map(o -> (JwtOAuth2User) o)
//                .map(JwtOAuth2User::getJwtTokenValue)
//                .map(bearerToken -> {
//                    ServerHttpRequest.Builder builder = exchange.getRequest().mutate();
//                    builder.header(HttpHeaders.AUTHORIZATION, "Bearer " + bearerToken);
//                    ServerHttpRequest request = builder.build();
//                    return exchange.mutate().request(request).build();})
//                .defaultIfEmpty(exchange)
//                .flatMap(chain::filter);
        return (exchange, chain) -> chain.filter(exchange)
                .then(Mono.just(exchange))
                .map(serverWebExchange -> {
                    //adds header to response
                    serverWebExchange.getResponse().getHeaders().set("CUSTOM-RESPONSE-HEADER",
                            HttpStatus.OK.equals(serverWebExchange.getResponse().getStatusCode()) ? "It worked": "It did not work");
                    return serverWebExchange;
                })
                .then();
    }

    public static class Config {

    }
}