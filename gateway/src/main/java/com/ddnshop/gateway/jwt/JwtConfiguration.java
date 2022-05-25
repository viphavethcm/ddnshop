package com.ddnshop.gateway.jwt;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import reactor.core.publisher.Mono;
//import sun.security.rsa.RSAPublicKeyImpl;


@Configuration
public class JwtConfiguration implements ReactiveJwtDecoder {

    @Override
    public Mono<Jwt> decode(String token) throws JwtException {
        return null;
    }
}
