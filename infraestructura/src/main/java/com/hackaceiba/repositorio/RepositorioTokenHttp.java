package com.hackaceiba.repositorio;

import com.hackaceiba.modelo.TokenResponse;
import com.hackaceiba.reporsitorio.RepositorioToken;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class RepositorioTokenHttp implements RepositorioToken {

    @Value("${svc-api.hostname}")
    private String host;

    @Value("${svc-api.port}")
    private String port;

    private RestTemplate restTemplate;
    
    public RepositorioTokenHttp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @HystrixCommand(fallbackMethod = "obtenerTokenFallback",
    	    commandProperties = {
    	    		@HystrixProperty(
                            name= "circuitBreaker.requestVolumeThreshold",
                            value="4"),
    	    		@HystrixProperty(
                            name= "circuitBreaker.sleepWindowInMilliseconds", 
                            value="15000"),
    	    		@HystrixProperty(
                            name= "circuitBreaker.enabled", 
                            value = "true")
    	    })
    public TokenResponse obtenerToken(String numero) {
    	
    	String url = host + ":" + port + "/?number=" + numero;
    	ResponseEntity<TokenResponse> respuesta =  restTemplate.getForEntity(url,
    			TokenResponse.class);
    	
    	return respuesta.getBody();
    }
    
    public TokenResponse obtenerTokenFallback(String numero) {
    	throw new RuntimeException();
    }
}
