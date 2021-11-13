package com.hackaceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@Profile("!test")
@Configuration
public class ConfiguracionClienteWeb {

    @Bean
    RestTemplate obtenerClienteWeb() {
        return new RestTemplate();
    }
}
