package com.hackaceiba.manejador;

import com.hackaceiba.modelo.TokenResponse;
import com.hackaceiba.reporsitorio.RepositorioToken;

import javax.inject.Named;

@Named
public class ManejadorToken {

    public RepositorioToken repositorioToken;

    public ManejadorToken(RepositorioToken repositorioToken){
        this.repositorioToken=repositorioToken;
    }

    public TokenResponse obtenerToken(String numero){
    	TokenResponse token = null;
    	
    	try {
    		token = repositorioToken.obtenerToken(numero);
    	}catch(RuntimeException e) {
    		return new TokenResponse();
    	}
    	
    	return token; 
    }

}
