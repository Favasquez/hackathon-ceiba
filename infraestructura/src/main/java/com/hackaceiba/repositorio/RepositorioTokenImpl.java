package com.hackaceiba.repositorio;

import com.hackaceiba.modelo.TokenResponse;
import com.hackaceiba.reporsitorio.RepositorioToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class RepositorioTokenImpl implements RepositorioToken {

    @Value("${svc-api.hostname}")
    private String host;

    @Value("${svc-api.port}")
    private String port;

    private WebClient webClient;

    public RepositorioTokenImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public TokenResponse obtenerToken(String numero) {
        return this.webClient.get()
                .uri(host+"/?number="+numero)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is5xxServerError, response -> response.bodyToMono(RuntimeException.class)
                        .map(error -> new RuntimeException()))
                .bodyToMono(TokenResponse.class).block();
    }
}
