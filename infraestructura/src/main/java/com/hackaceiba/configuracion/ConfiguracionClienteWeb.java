package com.hackaceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Profile("!test")
@Configuration
public class ConfiguracionClienteWeb {

    @Bean
    RestTemplate obtenerClienteWeb() {
        return new RestTemplate();
    }
}
