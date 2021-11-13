package com.hackaceiba;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ControladorToken {

	@GetMapping
	public String test() {
		return "El número ingresado es: " + 2;
	}
}
