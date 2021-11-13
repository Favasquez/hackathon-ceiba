package com.hackaceiba;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

	@GetMapping("/healthz")
	public String test() {
		return "OK";
	}
}
