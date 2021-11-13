package com.hackaceiba.manejador;

import com.hackaceiba.modelo.TokenResponse;
import com.hackaceiba.reporsitorio.RepositorioToken;
import lombok.AllArgsConstructor;

import javax.inject.Named;

@Named
@AllArgsConstructor
public class ManejadorToken {

    public RepositorioToken repositorioToken;

    public TokenResponse obtenerToken(String numero){
        return repositorioToken.obtenerToken(numero);
    }

}
