package com.hackaceiba.repositorio;

import com.hackaceiba.modelo.TokenResponse;
import com.hackaceiba.reporsitorio.RepositorioToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class RepositorioTokenImpl implements RepositorioToken {

    @Value("svc-api.hostname")
    private String host;

    @Value("svc-api.port")
    private String port;

    private WebClient webClient;

    @Override
    public TokenResponse obtenerToken(String numero) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(host)
                        .queryParam("number", numero)
                        .port(port)
                        .build())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(TokenResponse.class).blockFirst();
    }
}
