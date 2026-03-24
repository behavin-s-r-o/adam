package com.behavin.adam.Adam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

	@GetMapping("/ping")
	public String ping() {
		return "pong " + LocalDateTime.now().format(FORMATTER);
	}
}
