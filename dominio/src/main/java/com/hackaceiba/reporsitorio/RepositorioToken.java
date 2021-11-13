package com.hackaceiba.reporsitorio;

import com.hackaceiba.modelo.TokenResponse;

public interface RepositorioToken {

    TokenResponse obtenerToken(String numero);
}
