package com.hackaceiba.manejador;

import com.hackaceiba.cache.Cache;
import com.hackaceiba.modelo.TokenResponse;
import com.hackaceiba.reporsitorio.RepositorioToken;

import javax.inject.Named;


@Named
public class ManejadorToken {

	public RepositorioToken repositorioToken;
    public Cache cache;

    public ManejadorToken(RepositorioToken repositorioToken, Cache cache){
    	this.repositorioToken = repositorioToken;
    	this.cache = cache;
    }

    public TokenResponse obtenerToken(String numero){
    	TokenResponse token = null;

    	token = (TokenResponse) this.cache.get(numero);

    	if(token == null){
			try {
				token = repositorioToken.obtenerToken(numero);
				this.cache.put(numero, token, token.calculateMillisValidity());
			} catch(RuntimeException e) {
				token = new TokenResponse();
			}
		}

		return token;
    }

}
