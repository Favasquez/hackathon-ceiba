package com.hackaceiba.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
public class TokenResponse {
    public String hostname;
    public String method;
    public String url;
    public String data;
    public String date;
    public String validitySeconds;
    public String token;
}
