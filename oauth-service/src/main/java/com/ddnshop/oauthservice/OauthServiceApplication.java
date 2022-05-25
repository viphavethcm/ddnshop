package com.ddnshop.oauthservice;

import com.ddnshop.oauthservice.config.AppProperties;
import org.apache.tomcat.util.http.LegacyCookieProcessor;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.security.Security;
//import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
//@EnableFeignClients("com.ddnshop.oauthservice")
@EnableConfigurationProperties(AppProperties.class)
public class OauthServiceApplication {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static void main(String[] args) {
        SpringApplication.run(OauthServiceApplication.class, args);
    }

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> cookieProcessorCustomizer() {
        return tomcatServletWebServerFactory -> tomcatServletWebServerFactory.addContextCustomizers((TomcatContextCustomizer) context -> {
            context.setCookieProcessor(new LegacyCookieProcessor());
        });
    }
}
