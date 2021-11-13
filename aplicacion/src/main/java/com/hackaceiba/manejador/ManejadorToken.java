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
        return repositorioToken.obtenerToken(numero);
    }

}
