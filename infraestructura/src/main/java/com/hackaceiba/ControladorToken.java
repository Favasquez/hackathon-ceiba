package com.hackaceiba;

import com.hackaceiba.manejador.ManejadorToken;
import com.hackaceiba.modelo.TokenResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class ControladorToken {

	private ManejadorToken manejadorToken;

	public ControladorToken(ManejadorToken manejadorToken){
		this.manejadorToken = manejadorToken;
	}

	@GetMapping
	public TokenResponse obtenerToken(@RequestParam("number") String number) {
		return manejadorToken.obtenerToken(number);
	}
}
